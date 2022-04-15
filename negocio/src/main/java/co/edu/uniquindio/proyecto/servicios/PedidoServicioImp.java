package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Pedido;
import co.edu.uniquindio.proyecto.repositorios.PedidoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServicioImp implements PedidoServicio{

    private final PedidoRepo pedidoRepo;

    public PedidoServicioImp(PedidoRepo pedidoRepo) {
        this.pedidoRepo = pedidoRepo;
    }


    @Override
    public Pedido registrarPedido(Pedido p) throws Exception {
        return null;
    }

    @Override
    public Pedido actualizarPedido(Pedido p) throws Exception {
        return null;
    }

    @Override
    public void eliminarPedido(int idPedido) throws Exception {

    }

    @Override
    public List<Pedido> listarPedido() {
        return null;
    }
}
