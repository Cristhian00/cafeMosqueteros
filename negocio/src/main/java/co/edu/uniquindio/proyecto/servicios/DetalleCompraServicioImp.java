package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;

import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCompraServicioImp implements DetalleCompraServicio {

    private final DetalleCompraRepo detalleCompraRepo;
    private final ProductoRepo productoRepo;
    private final CompraRepo compraRepo;

    public DetalleCompraServicioImp(DetalleCompraRepo detalleCompraRepo, ProductoRepo productoRepo, CompraRepo compraRepo) {
        this.detalleCompraRepo = detalleCompraRepo;
        this.productoRepo = productoRepo;
        this.compraRepo = compraRepo;

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

    @Override
    public DetalleCompra registrarDetalleCompra(DetalleCompra detalleCompra) throws Exception {

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
            throw new Exception("No se puede agregar la compra debido a  su estado");
        }

       DetalleCompra dc = detalleCompraRepo.save(detalleCompra);

        return dc;
    }

    @Override
    public DetalleCompra actualizarDetalleCompra(DetalleCompra detalleCompra) throws Exception {

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
        detalleCompraRepo.save(detalleCompra);
        return detalleCompra;
    }

    @Override
    public boolean eliminarDetalleCompra(int idCompra, int idProducto) throws Exception {

        if (existeCompra(idCompra)) {
            throw new Exception("No existe la compra");
        }
        if (existeProducto(idProducto)) {
            throw new Exception("No existe el producto");
        }
        if (estadoCompra(idCompra) == false) {
            throw new Exception("No se puede eliminar el detalle debido a que ya esta en proceso");
        }
        Compra c = compraRepo.obtenerCompra(idCompra);
        Producto p = productoRepo.obtenerProducto(idProducto);

        DetalleCompra detalleCompra = detalleCompraRepo.findByProductoDetalleAndCompraDetalle(p, c);

        detalleCompraRepo.delete(detalleCompra);

        return true;
    }

    @Override
    public List<DetalleCompra> listarDetalleCompra() {
        return detalleCompraRepo.findAll();
    }
}
