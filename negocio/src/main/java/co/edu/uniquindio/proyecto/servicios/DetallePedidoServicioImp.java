package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.DetallePedido;
import co.edu.uniquindio.proyecto.repositorios.DetallePedidoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServicioImp implements DetallePedidoServicio {

    private final DetallePedidoRepo detallePedidoRepo;

    public DetallePedidoServicioImp(DetallePedidoRepo detallePedidoRepo) {
        this.detallePedidoRepo = detallePedidoRepo;
    }

    @Override
    public DetallePedido registrarDetallePedido(DetallePedido detallePedido) throws Exception {
        return null;
    }

    @Override
    public DetallePedido actualizarDetallePedido(DetallePedido detallePedido) throws Exception {
        return null;
    }

    @Override
    public void eliminarDetallePedido(int idProducto) throws Exception {

    }

    @Override
    public List<DetallePedido> listarDetallePedido() {
        return null;
    }
}
