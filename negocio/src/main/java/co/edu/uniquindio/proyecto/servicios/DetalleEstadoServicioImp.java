package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DetalleEstadoServicioImp implements DetalleEstadoServicio {

    private final DetalleEstadoRepo detalleEstadoRepo;
    private final CompraRepo compraRepo;
    private final DetalleCompraRepo detalleCompraRepo;
    private final SocioRepo socioRepo;
    private final ProductoRepo productoRepo;
    private final InventarioRepo inventarioRepo;

    public DetalleEstadoServicioImp(DetalleEstadoRepo detalleEstadoRepo, CompraRepo compraRepo, DetalleCompraRepo detalleCompraRepo, SocioRepo socioRepo, ProductoRepo productoRepo, InventarioRepo inventarioRepo) {
        this.detalleEstadoRepo = detalleEstadoRepo;
        this.compraRepo = compraRepo;
        this.detalleCompraRepo = detalleCompraRepo;
        this.socioRepo = socioRepo;
        this.productoRepo = productoRepo;
        this.inventarioRepo = inventarioRepo;
    }

    public boolean existeInventario(String cedula, int idProducto) {
        Socio socio = socioRepo.obtenerUsuarioCedula(cedula);

        for (Inventario inventario : socio.getInventarios()) {
            if (inventario.getProductoInventario().getIdProducto() == idProducto) {
                return true;
            }
        }
        return false;
    }

    @Override
    public DetalleEstado registrarDetalleEstado(DetalleEstado detalleEstado) throws Exception {

        Producto productoAux;
        Compra compra = compraRepo.obtenerCompra(detalleEstado.getCompraEstado().getIdCompra());
        Socio socio = socioRepo.obtenerUsuarioCedula(compra.getSocioCompra().getCedula());
        detalleEstado.setFecha(new Date());

        if (detalleEstado.getEstadoDetalle().getNombre().equalsIgnoreCase("RECHAZADO")) {
            for (DetalleCompra detalle : compra.getDetalleCompras()) {
                productoAux = productoRepo.obtenerProducto(detalle.getProductoDetalle().getIdProducto());
                productoAux.setUnidadesDisponibles(productoAux.getUnidadesDisponibles() + detalle.getCantidad());
                productoRepo.save(productoAux);
            }
        } else if (detalleEstado.getEstadoDetalle().getNombre().equalsIgnoreCase("APROBADA")) {
            for (DetalleCompra detalle : compra.getDetalleCompras()) {
                productoAux = productoRepo.obtenerProducto(detalle.getProductoDetalle().getIdProducto());
                if (existeInventario(socio.getCedula(), productoAux.getIdProducto())) {
                    Inventario inventario = inventarioRepo.obtenerSocioInventarioAndProductoInventario(socio, productoAux);
                    inventario.setCantidad(inventario.getCantidad() + detalle.getCantidad());
                    inventarioRepo.save(inventario);
                } else {
                    Inventario inventario = new Inventario(detalle.getCantidad(), socio, productoAux);
                    inventarioRepo.save(inventario);
                }
            }
            //AGREGAR EL DTO PARA LAS GANANCIAS
        }
        return null;
    }

    @Override
    public List<DetalleEstado> listarDetalleEstado() {
        return null;
    }
}
