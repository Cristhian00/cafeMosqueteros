package co.edu.uniquindio.proyecto.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NoSocioTest {

    @Autowired
    private NoSocioRepo noSocioRepo;

    @Test
    public void registrarNoSocioTest(){

    }
    @Test
    public void eliminarNoSocioTest(){


    }
    @Test
    public void actualizarNoSocioTest(){

    }
    @Test
    public void listarNoSocioTest(){

    }
}
