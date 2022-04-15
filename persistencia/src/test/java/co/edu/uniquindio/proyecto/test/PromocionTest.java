package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Promocion;
import co.edu.uniquindio.proyecto.repositorios.PromocionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PromocionTest {

    @Autowired
    private PromocionRepo promocionRepo;

    @Test
    public void registrarPromocionTest() {
        Promocion promocion = new Promocion("Cupon de descuento", 0.5);
        Promocion guardado = promocionRepo.save(promocion);

        Assertions.assertNotNull(guardado);
    }

    @Test
    public void eliminarPromocionTest() {
        Promocion promocion = new Promocion("Cupon de descuento", 0.5);
        Promocion guardado = promocionRepo.save(promocion);

        promocionRepo.delete(guardado);
        Promocion buscado = promocionRepo.findById(1).orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    public void actualizarPromocionTest() {
        Promocion promocion = new Promocion("Cupon de descuento", 0.5);
        Promocion guardado = promocionRepo.save(promocion);

        guardado.setDescuento(1.0);
        promocionRepo.save(guardado);

        Promocion buscado = promocionRepo.findById(1).orElse(null);
        Assertions.assertEquals(1.0, buscado.getDescuento());
    }

    @Test
    public void listarPromocionTest() {
        List<Promocion> lista = promocionRepo.findAll();
        System.out.println(lista);
    }
}
