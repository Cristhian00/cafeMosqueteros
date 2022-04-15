package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.EstadoCompra;
import co.edu.uniquindio.proyecto.repositorios.EstadoCompraRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoCompraServicioImp implements EstadoCompraServicio{

    private final EstadoCompraRepo estadoCompraRepo;

    public EstadoCompraServicioImp(EstadoCompraRepo estadoCompraRepo) {
        this.estadoCompraRepo = estadoCompraRepo;
    }

    @Override
    public EstadoCompra registrarEstadoCompra(EstadoCompra estadoCompra) throws Exception {
        return null;
    }

    @Override
    public EstadoCompra actualizarEstadoCompra(EstadoCompra estadoCompra) throws Exception {
        return null;
    }

    @Override
    public void eliminarEstadoCompra(int idEstado) throws Exception {

    }

    @Override
    public List<EstadoCompra> listarEstadoCompra() {
        return null;
    }
}
