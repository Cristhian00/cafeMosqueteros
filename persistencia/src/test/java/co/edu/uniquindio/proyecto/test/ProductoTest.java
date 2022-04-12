package co.edu.uniquindio.proyecto.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoTest {

    @Autowired
    private ProductoRepo productoRepo;
    @Test
    public void registrarProductoTest(){

    }
    @Test
    public void eliminarProductoTest(){


    }
    @Test
    public void actualizarProductoTest(){

    }
    @Test
    public void listarProductoTest(){

    }
}
