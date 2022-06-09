package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DetallePedidoTest {
    @Autowired
    private DetallePedidoRepo detallePedidoRepo;
    @Autowired
    private PedidoRepo pedidoRepo;
    @Autowired
    private DistribuidorRepo distribuidorRepo;
    @Autowired
    private ProductoRepo productoRepo;
    @Autowired
    private TipoProductoRepo tipoProductoRepo;

    @Test
    public void registrarDetallePedidoTest() {
        Distribuidor distribuidor = new Distribuidor("0921", "Abelardo Sanchez", "Cali");
        distribuidorRepo.save(distribuidor);

        Pedido pedido = new Pedido(new Date(), 40.900, distribuidor);
        pedidoRepo.save(pedido);

        TipoProducto tipoProducto = new TipoProducto("Cafe 100% colombiano", "300", 38.56);
        tipoProductoRepo.save(tipoProducto);

        Producto producto = new Producto("café mosqueteros molido", "Cafe molido", 35.000, 25.000, 20, tipoProducto);
        productoRepo.save(producto);

        DetallePedido detallePedido = new DetallePedido(3, producto.getPrecioCompra(),
                producto, pedido);
        DetallePedido guardado = detallePedidoRepo.save(detallePedido);

        Assertions.assertNotNull(guardado);
    }

    @Test
    public void eliminarDetallePedidoTest() {

        Distribuidor distribuidor = new Distribuidor("0921", "Abelardo Sanchez", "Cali");
        distribuidorRepo.save(distribuidor);

        Pedido pedido = new Pedido(new Date(), 40.900, distribuidor);
        pedidoRepo.save(pedido);

        TipoProducto tipoProducto = new TipoProducto("Cafe 100% colombiano", "300", 38.56);
        tipoProductoRepo.save(tipoProducto);

        Producto producto = new Producto("café mosqueteros molido", "Cafe molido", 35.000, 25.000, 20, tipoProducto);
        productoRepo.save(producto);

        DetallePedido detallePedido = new DetallePedido(3, 35.000, producto, pedido);
        DetallePedido guardado = detallePedidoRepo.save(detallePedido);

        detallePedidoRepo.delete(guardado);
        DetallePedido buscado = detallePedidoRepo.findByProductoPedidoAndPedidoDetalle(producto, pedido);

        Assertions.assertNull(buscado);
    }

    @Test
    public void actualizarDetallePedidoTest() {
        Distribuidor distribuidor = new Distribuidor("0921", "Abelardo Sanchez", "Cali");
        distribuidorRepo.save(distribuidor);

        Pedido pedido = new Pedido(new Date(), 40.900, distribuidor);
        pedidoRepo.save(pedido);

        TipoProducto tipoProducto = new TipoProducto("Cafe 100% colombiano", "300",
                38.56);
        tipoProductoRepo.save(tipoProducto);

        Producto producto = new Producto("café mosqueteros molido", "Cafe molido",
                35.000, 25.000, 20, tipoProducto);
        productoRepo.save(producto);

        DetallePedido detallePedido = new DetallePedido(3, producto.getPrecioCompra(), producto, pedido);
        DetallePedido guardado = detallePedidoRepo.save(detallePedido);

        guardado.setCantidad(5);

        detallePedidoRepo.save(guardado);

        DetallePedido buscado = detallePedidoRepo.findByProductoPedidoAndPedidoDetalle(producto, pedido);
        Assertions.assertEquals(5, buscado.getCantidad());
    }

    @Test
    public void listarDetallePedidoTest() {

    }
}
