package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.repositorios.InventarioRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class InventarioTest {

    @Autowired
    private InventarioRepo invetarioRepo;

    @Test
    public void registrarInventarioTest(){

    }
    @Test
    public void eliminarInventarioTest(){


    }
    @Test
    public void actualizarInventarioTest(){

    }
    @Test
    public void listarInventarioTest(){

    }
}
