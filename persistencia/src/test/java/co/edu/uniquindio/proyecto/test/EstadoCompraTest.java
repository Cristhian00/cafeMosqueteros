package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.repositorios.EstadoCompraRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EstadoCompraTest {
    @Autowired
    private EstadoCompraRepo estadoCompraRepo;
    @Test
    public void registrarEstadoCompraTest(){

    }
    @Test
    public void eliminarEstadoCompraTest(){


    }
    @Test
    public void actualizarEstadoCompraTest(){

    }
    @Test
    public void listarEstadoCompraTest(){

    }
}
