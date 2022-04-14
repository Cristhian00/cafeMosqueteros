package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.repositorios.PromocionRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PromocionTest {

    @Autowired
    private PromocionRepo promocionRepo;
    @Test
    public void registrarPromocionTest(){

    }
    @Test
    public void eliminarPromocionTest(){


    }
    @Test
    public void actualizarPromocionTest(){

    }
    @Test
    public void listarPromocionTest(){

    }
}
