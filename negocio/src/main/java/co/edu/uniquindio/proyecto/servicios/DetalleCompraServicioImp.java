package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCompraServicioImp implements DetalleCompraServicio {

    private final DetalleCompraRepo detalleCompraRepo;
    private final ProductoRepo productoRepo;
    private final CompraRepo compraRepo;
    private final SocioRepo socioRepo;
    private final InventarioRepo inventarioRepo;

    public DetalleCompraServicioImp(DetalleCompraRepo detalleCompraRepo, ProductoRepo productoRepo,
                                    CompraRepo compraRepo, SocioRepo socioRepo, InventarioRepo inventarioRepo) {
        this.detalleCompraRepo = detalleCompraRepo;
        this.productoRepo = productoRepo;
        this.compraRepo = compraRepo;
        this.socioRepo = socioRepo;
        this.inventarioRepo = inventarioRepo;
    }

    public Boolean existeProducto(int idProducto) {
        Optional<Producto> producto = productoRepo.findById(idProducto);
        return producto.isEmpty();
    }

    public Boolean existeCompra(int idCompra) {
        Optional<Compra> compra = compraRepo.findById(idCompra);
        return compra.isEmpty();
    }

    public boolean estadoCompra(int idCompra) {
        Compra compra = compraRepo.obtenerCompra(idCompra);
        List<DetalleEstado> list = compra.getEstados();

        for (DetalleEstado d : list) {
            if (d.getEstadoDetalle().getDescripcion().equalsIgnoreCase("APROBADA")
                    || d.getEstadoDetalle().getDescripcion().equalsIgnoreCase("RECHAZADA")) {
                return true;
            }
        }
        return false;
    }

    public double precioUnitario(int idProducto) {
        Producto p = productoRepo.obtenerProducto(idProducto);
        return p.getPrecioVenta();
    }

    public int unidadesDisponible(int idProducto) {
        Producto p = productoRepo.obtenerProducto(idProducto);
        return p.getUnidadesDisponibles();
    }

    public void validaciones(DetalleCompra detalleCompra) throws Exception {
        if (detalleCompra.getProductoDetalle() == null) {
            throw new Exception("El detalle compra debe tener un producto asociado");
        }
        if (existeProducto(detalleCompra.getProductoDetalle().getIdProducto())) {
            throw new Exception("No existe producto con ese id");
        }
        if (detalleCompra.getCompraDetalle() == null) {
            throw new Exception("El detalle compra debe tener una compra");
        }
        if (existeCompra(detalleCompra.getCompraDetalle().getIdCompra())) {
            throw new Exception("No existe compra con ese id");
        }
        if (estadoCompra(detalleCompra.getCompraDetalle().getIdCompra()) == true) {
            throw new Exception("No se puede agregar más detalles a la compra debido a su estado");
        }
        if (detalleCompra.getCantidad() <= 0) {
            throw new Exception("Debe ingresar un valor positivo mayor a cero en la cnatidad de productos");
        }
    }

    @Override
    public DetalleCompra registrarDetalleCompra(DetalleCompra detalleCompra) throws Exception {

        validaciones(detalleCompra);
        if (unidadesDisponible(detalleCompra.getProductoDetalle().getIdProducto()) < detalleCompra.getCantidad()) {
            throw new Exception("No hay suficientes unidades disponibles");
        }
        detalleCompra.setPrecioUnitario(precioUnitario(detalleCompra.getProductoDetalle().getIdProducto()));

        Compra compra = compraRepo.obtenerCompra(detalleCompra.getCompraDetalle().getIdCompra());
        compra.setTotal(compra.getTotal() + (detalleCompra.getCantidad() * detalleCompra.getPrecioUnitario()));
        compraRepo.save(compra);

        Producto producto = productoRepo.obtenerProducto(detalleCompra.getProductoDetalle().getIdProducto());
        producto.setUnidadesDisponibles(producto.getUnidadesDisponibles() - detalleCompra.getCantidad());
        productoRepo.save(producto);

        DetalleCompra dc = detalleCompraRepo.save(detalleCompra);

        return dc;
    }

    @Override
    public DetalleCompra actualizarCantidadDetalleCompra(DetalleCompra detalleCompra, int cantidad) throws Exception {

        validaciones(detalleCompra);
        Compra compra = compraRepo.obtenerCompra(detalleCompra.getCompraDetalle().getIdCompra());
        Producto producto = productoRepo.obtenerProducto(detalleCompra.getProductoDetalle().getIdProducto());
        DetalleCompra detalleOld = detalleCompraRepo.findByProductoDetalleAndCompraDetalle(producto, compra);

        if (detalleOld.getCantidad() < cantidad) {
            if (unidadesDisponible(detalleCompra.getProductoDetalle().getIdProducto()) < cantidad) {
                throw new Exception("No hay suficientes unidades disponibles");
            }
            producto.setUnidadesDisponibles(producto.getUnidadesDisponibles() -
                    (cantidad - detalleOld.getCantidad()));
            productoRepo.save(producto);

            compra.setTotal(compra.getTotal() + ((cantidad - detalleOld.getCantidad()) *
                    detalleCompra.getPrecioUnitario()));
            compraRepo.save(compra);
        } else if (detalleOld.getCantidad() > cantidad) {
            producto.setUnidadesDisponibles(producto.getUnidadesDisponibles() +
                    (detalleOld.getCantidad() - cantidad));
            productoRepo.save(producto);

            compra.setTotal(compra.getTotal() - ((detalleOld.getCantidad() - cantidad) * detalleCompra.getPrecioUnitario()));
            compraRepo.save(compra);
        }
        detalleCompra.setCantidad(cantidad);
        detalleCompraRepo.save(detalleCompra);
        return detalleCompra;
    }

    @Override
    public boolean eliminarDetalleCompra(DetalleCompra detalleCompra) throws Exception {

        validaciones(detalleCompra);
        Compra compra = compraRepo.obtenerCompra(detalleCompra.getCompraDetalle().getIdCompra());
        Producto producto = productoRepo.obtenerProducto(detalleCompra.getProductoDetalle().getIdProducto());

        producto.setUnidadesDisponibles(producto.getUnidadesDisponibles() + detalleCompra.getCantidad());
        productoRepo.save(producto);

        compra.setTotal(compra.getTotal() - (detalleCompra.getCantidad() * detalleCompra.getPrecioUnitario()));
        compraRepo.save(compra);

        detalleCompraRepo.delete(detalleCompra);

        return true;
    }

    @Override
    public List<DetalleCompra> listarDetalleCompra() {
        return detalleCompraRepo.findAll();
    }
}
