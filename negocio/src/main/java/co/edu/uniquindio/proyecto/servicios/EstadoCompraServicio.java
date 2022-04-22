package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.EstadoCompra;

import java.util.List;

public interface EstadoCompraServicio {
    EstadoCompra registrarEstadoCompra(EstadoCompra estadoCompra) throws Exception;

    EstadoCompra actualizarEstadoCompra(EstadoCompra estadoCompra) throws Exception;

    boolean eliminarEstadoCompra(int idEstado) throws Exception;

    List<EstadoCompra> listarEstadoCompra();
}
