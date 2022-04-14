package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.repositorios.GananciaRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GananciaTest {

    @Autowired
    private GananciaRepo gananciaRepo;
    @Test
    public void registrarGananciaTest(){

    }
    @Test
    public void eliminarGananciaTest(){


    }
    @Test
    public void actualizarGananciaTest(){

    }
    @Test
    public void listarGananciaTest(){

    }
}
