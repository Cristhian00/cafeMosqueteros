package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.DetallePedido;
import co.edu.uniquindio.proyecto.entidades.LlaveDetallePedido;
import co.edu.uniquindio.proyecto.entidades.Pedido;
import co.edu.uniquindio.proyecto.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepo extends JpaRepository<DetallePedido, LlaveDetallePedido> {

    DetallePedido findByProductoPedidoAndPedidoDetalle(Producto producto, Pedido pedido);
}
