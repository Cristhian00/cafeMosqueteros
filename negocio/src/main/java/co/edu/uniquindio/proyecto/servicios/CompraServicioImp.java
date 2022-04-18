package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.EstadoCompraRepo;
import co.edu.uniquindio.proyecto.repositorios.SocioRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CompraServicioImp implements CompraServicio {

    private final CompraRepo compraRepo;
    private final SocioRepo socioRepo;
    private final EstadoCompraRepo estadoCompraRepo;

    public CompraServicioImp(CompraRepo compraRepo, SocioRepo socioRepo, EstadoCompraRepo estadoCompraRepo) {
        this.compraRepo = compraRepo;
        this.socioRepo = socioRepo;
        this.estadoCompraRepo = estadoCompraRepo;
    }

    public boolean idDisponible(int id) {
        Optional<Compra> compra = compraRepo.findById(id);
        return compra.isEmpty();
    }

    public boolean existeSocio(String cedula) {
        Optional<Socio> socio = socioRepo.findById(cedula);
        return socio.isEmpty();
    }

    public EstadoCompra estadoCompra(String estado) {
        return estadoCompraRepo.findByDescripcion(estado);
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
        if (c.getDetalleCompras().isEmpty()) {
            throw new Exception("Debe haber al menos un detalle de compra");
        }
    }

    @Override
    public Compra registrarCompra(Compra c) throws Exception {
        validaciones(c);
        List<DetalleEstado> lista = c.getEstados();
        lista.add(new DetalleEstado(new Date(), estadoCompra("PENDIENTE"), c));
        c.setEstados(lista);
        compraRepo.save(c);

        return c;
    }

    @Override
    public boolean eliminarCompra(int idCompra) throws Exception {
        if (idDisponible(idCompra)) {
            throw new Exception("La compra no se encuentra registrada");
        }
        Compra c = compraRepo.obtenerCompra(idCompra);
        List<DetalleEstado> estados = c.getEstados();

        for (DetalleEstado d : estados) {
            if (d.getEstadoDetalle().getDescripcion().equalsIgnoreCase("APROBADO")
                    || d.getEstadoDetalle().getDescripcion().equalsIgnoreCase("RECHAZADO")
                    || d.getEstadoDetalle().getDescripcion().equalsIgnoreCase("ENVIADO")) {
                throw new Exception("La compra no se puede eliminar porque su estado ya fue procesado");
            }
        }

        compraRepo.delete(c);

        return true;
    }

    @Override
    public List<Compra> listarCompra() {
        return compraRepo.findAll();
    }
}
