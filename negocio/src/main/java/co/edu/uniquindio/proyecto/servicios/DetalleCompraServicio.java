package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.DetalleCompra;

import java.util.List;

public interface DetalleCompraServicio {

    DetalleCompra registrarDetalleCompra(DetalleCompra detalleCompra) throws Exception;

    DetalleCompra actualizarDetalleCompra(DetalleCompra detalleCompra) throws Exception;

   boolean eliminarDetalleCompra(int idCompra, int idProducto) throws Exception;

    List<DetalleCompra> listarDetalleCompra();
}
