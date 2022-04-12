package co.edu.uniquindio.proyecto.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HistorialJerarquiaTest {

    @Autowired
    private HistorialJerarquiaRepo historialJerarquiaRepo;

    @Test
    public void registrarHistorialJerarquiaTest(){

    }
    @Test
    public void eliminarHistorialJerarquiaTest(){


    }
    @Test
    public void actualizarHistorialJerarquiaTest(){

    }
    @Test
    public void listarHistorialJerarquiaTest(){

    }
}
