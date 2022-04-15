package co.edu.uniquindio.proyecto.servicios;



import co.edu.uniquindio.proyecto.entidades.Pedido;

import java.util.List;

public interface PedidoServicio {
    Pedido registrarPedido(Pedido p) throws Exception;

    Pedido actualizarPedido(Pedido p) throws Exception;

    void eliminarPedido(int idPedido) throws Exception;

    List<Pedido> listarPedido();
}
