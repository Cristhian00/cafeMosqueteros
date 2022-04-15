package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.DetalleEstado;
import co.edu.uniquindio.proyecto.repositorios.DetalleEstadoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleEstadoServicioImp implements  DetalleEstadoServicio{

    private final DetalleEstadoRepo detalleEstadoRepo;

    public DetalleEstadoServicioImp(DetalleEstadoRepo detalleEstadoRepo) {
        this.detalleEstadoRepo = detalleEstadoRepo;
    }

    @Override
    public DetalleEstado registrarDetalleEstado(DetalleEstado detalleEstado) throws Exception {
        return null;
    }

    @Override
    public DetalleEstado actualizarDetalleEstado(DetalleEstado detalleEstado) throws Exception {
        return null;
    }

    @Override
    public void eliminarDetalleEstado(int idCompra) throws Exception {

    }

    @Override
    public List<DetalleEstado> listarDetalleEstado() {
        return null;
    }
}
