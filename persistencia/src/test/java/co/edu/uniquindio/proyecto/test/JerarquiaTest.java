package co.edu.uniquindio.proyecto.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JerarquiaTest {

    @Autowired
    private JerarquiaRepo jerarquiaRepo;

    @Test
    public void registrarJerarquiaTest(){

    }
    @Test
    public void eliminarJerarquiaTest(){


    }
    @Test
    public void actualizarJerarquiaTest(){

    }
    @Test
    public void listarJerarquiaTest(){

    }
}
