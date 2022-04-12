package co.edu.uniquindio.proyecto.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PedidoTest {

    @Autowired
    private PedidoRepo pedidoRepo;
    @Test
    public void registrarPedidoTest(){

    }
    @Test
    public void eliminarPedidoTest(){


    }
    @Test
    public void actualizarPedidoTest(){

    }
    @Test
    public void listarPedidoTest(){

    }
}
