package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.DetallePedido;

import java.util.List;

public interface DetallePedidoServicio {

    DetallePedido registrarDetallePedido(DetallePedido detallePedido) throws Exception;

    DetallePedido actualizarDetallePedido(DetallePedido detallePedido) throws Exception;

    void eliminarDetallePedido(int idProducto) throws Exception;

    List<DetallePedido> listarDetallePedido();
}
