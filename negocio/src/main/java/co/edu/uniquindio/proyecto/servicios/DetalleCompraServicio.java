package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.DetalleCompra;

import java.util.List;

public interface DetalleCompraServicio {

    DetalleCompra registrarDetalleCompra(DetalleCompra detalleCompra) throws Exception;

    DetalleCompra actualizarDetalleCompra(DetalleCompra detalleCompra) throws Exception;

    void eliminarDetalleCompra(int idCompra) throws Exception;

    List<DetalleCompra> listarDetalleCompra();
}