package co.edu.uniquindio.proyecto.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SocioTest {

    @Autowired
    private SocioRepo socioRepo;
    @Test
    public void registrarSocioTest(){

    }
    @Test
    public void eliminarSocioTest(){


    }
    @Test
    public void actualizarSocioTest(){

    }
    @Test
    public void listarSocioTest(){

    }
}
