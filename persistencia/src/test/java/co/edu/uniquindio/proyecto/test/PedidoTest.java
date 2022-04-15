package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Distribuidor;
import co.edu.uniquindio.proyecto.entidades.Pedido;
import co.edu.uniquindio.proyecto.repositorios.DistribuidorRepo;
import co.edu.uniquindio.proyecto.repositorios.PedidoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PedidoTest {

    @Autowired
    private PedidoRepo pedidoRepo;

    @Autowired
    private DistribuidorRepo distribuidorRepo;


    @Test
    public void registrarPedidoTest() {
        Distribuidor distribuidor = new Distribuidor("1314", "Fernando Gonzales", "Armenia");
        distribuidorRepo.save(distribuidor);

        Pedido pedido = new Pedido(new Date(), 120.500, distribuidor);
        Pedido guardado = pedidoRepo.save(pedido);

        Assertions.assertNotNull(guardado);
    }

    @Test
    public void eliminarPedidoTest() {
        Distribuidor distribuidor = new Distribuidor("1314", "Fernando Gonzales", "Armenia");
        distribuidorRepo.save(distribuidor);

        Pedido pedido = new Pedido(new Date(), 120.500, distribuidor);
        Pedido guardado = pedidoRepo.save(pedido);

        pedidoRepo.delete(guardado);
        Pedido buscado = pedidoRepo.findById(1).orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    public void actualizarPedidoTest() {
        Distribuidor distribuidor = new Distribuidor("1314", "Fernando Gonzales", "Armenia");
        distribuidorRepo.save(distribuidor);

        Pedido pedido = new Pedido(new Date(), 120500, distribuidor);
        Pedido guardado = pedidoRepo.save(pedido);

        guardado.setTotal(210000);
        pedidoRepo.save(guardado);

        Pedido buscado =  pedidoRepo.findById(1).orElse(null);
        Assertions.assertEquals(210000, buscado.getTotal());
    }

    @Test
    public void listarPedidoTest() {

    }
}
