package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.EstadoCompra;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstadoCompraServicio {
    EstadoCompra registrarEstadoCompra(EstadoCompra estadoCompra) throws Exception;

    EstadoCompra actualizarEstadoCompra(EstadoCompra estadoCompra) throws Exception;

    boolean eliminarEstadoCompra(int idEstado) throws Exception;

    EstadoCompra obtenerEstado(String nombre) throws Exception;

    List<EstadoCompra> listarEstadoCompra();
}
