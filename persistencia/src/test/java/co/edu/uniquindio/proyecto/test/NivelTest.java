package co.edu.uniquindio.proyecto.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NivelTest {

    @Autowired
    private NivelRepo nivelRepo;

    @Test
    public void registrarNivelTest(){

    }
    @Test
    public void eliminarNivelTest(){


    }
    @Test
    public void actualizarNivelTest(){

    }
    @Test
    public void listarNivelTest(){

    }
}
