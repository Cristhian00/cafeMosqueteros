package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DetallePedidoTest {
    @Autowired
    private  DetallePedidoRepo detallePedidoRepo;

    @Test
    public void registrarDetallePedidoTest(){

    }
    @Test
    public void eliminarDetallePedidoTest(){


    }
    @Test
    public void actualizarDetallePedidoTest(){

    }
    @Test
    public void listarDetallePedidoTest(){

    }
}
