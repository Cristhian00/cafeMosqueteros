package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.DetalleCompra;

import java.util.List;

public interface DetalleCompraServicio {

    DetalleCompra registrarDetalleCompra(DetalleCompra detalleCompra) throws Exception;

    DetalleCompra actualizarCantidadDetalleCompra(DetalleCompra detalleCompra, int cantidad) throws Exception;

    boolean eliminarDetalleCompra(DetalleCompra detalleCompra) throws Exception;

    List<DetalleCompra> listarDetalleCompra();
}
