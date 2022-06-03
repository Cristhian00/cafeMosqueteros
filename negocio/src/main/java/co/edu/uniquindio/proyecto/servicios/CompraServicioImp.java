package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CompraServicioImp implements CompraServicio {

    private final CompraRepo compraRepo;
    private final SocioRepo socioRepo;
    private final DetalleCompraRepo detalleCompraRepo;
    private final ProductoRepo productoRepo;
    private final InventarioRepo inventarioRepo;

    public CompraServicioImp(CompraRepo compraRepo, SocioRepo socioRepo, DetalleCompraRepo detalleCompraRepo, ProductoRepo productoRepo, InventarioRepo inventarioRepo) {
        this.compraRepo = compraRepo;
        this.socioRepo = socioRepo;
        this.detalleCompraRepo = detalleCompraRepo;
        this.productoRepo = productoRepo;
        this.inventarioRepo = inventarioRepo;
    }

    public boolean idDisponible(int id) {
        Optional<Compra> compra = compraRepo.findById(id);
        return compra.isEmpty();
    }

    public boolean existeSocio(String cedula) {
        Optional<Socio> socio = socioRepo.findById(cedula);
        return socio.isEmpty();
    }

    public EstadoSocio estadoSocio(String cedula) {
        Socio socio = socioRepo.obtenerUsuarioCedula(cedula);
        if (socio.getEstado() == EstadoSocio.ACTIVO) {
            return EstadoSocio.ACTIVO;
        } else if (socio.getEstado() == EstadoSocio.PENDIENTE) {
            return EstadoSocio.PENDIENTE;
        } else {
            return EstadoSocio.NO_ACTIVO;
        }
    }

    public void validaciones(Compra c) throws Exception {
        if (c.getSocioCompra() == null) {
            throw new Exception("La compra debe estar asociada a un socio");
        }
        if (existeSocio(c.getSocioCompra().getCedula())) {
            throw new Exception("El número de cédula no se encuentra asociado a ningún socio activo");
        }
        if (estadoSocio(c.getSocioCompra().getCedula()) == EstadoSocio.NO_ACTIVO) {
            throw new Exception("El socio no se encuentra activo");
        }
        if (estadoSocio(c.getSocioCompra().getCedula()) == EstadoSocio.PENDIENTE) {
            throw new Exception("El socio aun no se encuentra aprobado");
        }
    }

    @Override
    public Compra registrarCompra(Compra c) throws Exception {
        validaciones(c);
        c.setFecha(new Date());
        c.setTotal(0);
        c.setEstado(EstadoCompra.PENDIENTE);
        compraRepo.save(c);
        return c;
    }

    @Override
    public boolean eliminarCompra(int idCompra) throws Exception {
        if (idDisponible(idCompra)) {
            throw new Exception("La compra no se encuentra registrada");
        }
        Compra c = compraRepo.obtenerCompra(idCompra);

        if (c.getEstado().name().equalsIgnoreCase("APROBADA")
                || c.getEstado().name().equalsIgnoreCase("RECHAZADA")
                || c.getEstado().name().equalsIgnoreCase("CANCELADA")) {
            throw new Exception("La compra no se puede eliminar porque su estado ya fue procesado");
        }
        compraRepo.delete(c);
        return true;
    }

    @Override
    public Compra actualizarEstadoCompra(int idCompra, EstadoCompra estado) throws Exception {

        Producto productoAux;
        Compra compra = compraRepo.obtenerCompra(idCompra);
        Socio socio = socioRepo.obtenerUsuarioCedula(compra.getSocioCompra().getCedula());

        if(!(compra.getEstado().name().equalsIgnoreCase("PENDIENTE"))){
            throw new Exception("La compra ya no se puede modificar porque su estado ya no es PENDIENTE");
        }
        if (estado.name().equalsIgnoreCase("RECHAZADA") || estado.name().equalsIgnoreCase("CANCELADA")) {
            for (DetalleCompra detalle : detalleCompraRepo.obtenerDetallesCompra(compra.getIdCompra())) {
                productoAux = productoRepo.obtenerProducto(detalle.getProductoDetalle().getIdProducto());
                productoAux.setUnidadesDisponibles(productoAux.getUnidadesDisponibles() + detalle.getCantidad());
                productoRepo.save(productoAux);
            }
        } else if (estado.name().equalsIgnoreCase("APROBADA")) {
            for (DetalleCompra detalle : detalleCompraRepo.obtenerDetallesCompra(compra.getIdCompra())) {
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
        compra.setEstado(estado);
        compraRepo.save(compra);
        return compra;
    }

    public boolean existeInventario(String cedula, int idProducto) {
        Socio socio = socioRepo.obtenerUsuarioCedula(cedula);
        for (Inventario inventario : inventarioRepo.obtenerInventariosUsuario(socio.getCedula())) {
            if (inventario.getProductoInventario().getIdProducto() == idProducto) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Compra obtenerCompra(int id) throws Exception {

        if (idDisponible(id)) {
            throw new Exception("Debe ingresar un id que exista");
        }
        return compraRepo.obtenerCompra(id);
    }

    @Override
    public List<Compra> listarCompra() {
        return compraRepo.findAll();
    }
}
