package co.edu.uniquindio.proyecto.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DistribuidorTest {
    @Autowired
    private DistribuidorRepo distribuidorRepo;
    @Test
    public void registrarDistribuidorTest(){

    }
    @Test
    public void eliminarDistribuidorTest(){


    }
    @Test
    public void actualizarDistribuidorTest(){

    }
    @Test
    public void listarDistribuidorTest(){

    }
}
