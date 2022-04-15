package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Jerarquia;
import co.edu.uniquindio.proyecto.entidades.Promocion;
import co.edu.uniquindio.proyecto.repositorios.JerarquiaRepo;
import co.edu.uniquindio.proyecto.repositorios.PromocionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JerarquiaTest {

    @Autowired
    private JerarquiaRepo jerarquiaRepo;
    @Autowired
    private PromocionRepo promocionRepo;

    @Test
    public void registrarJerarquiaTest() {
        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Oro", 4, 200000, promocion);
        Jerarquia guardado = jerarquiaRepo.save(jerarquia);

        Assertions.assertNotNull(guardado);
    }

    @Test
    public void eliminarJerarquiaTest() {
        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Oro", 4, 200000, promocion);
        Jerarquia guardado = jerarquiaRepo.save(jerarquia);

        jerarquiaRepo.delete(guardado);
        Jerarquia buscado = jerarquiaRepo.findById(1).orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    public void actualizarJerarquiaTest() {
        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Oro", 4, 200000, promocion);
        Jerarquia guardado = jerarquiaRepo.save(jerarquia);

        guardado.setTotalventas(150000);
        jerarquiaRepo.save(guardado);

        Jerarquia buscado = jerarquiaRepo.findById(1).orElse(null);
        Assertions.assertEquals(150000, buscado.getTotalventas());
    }

    @Test
    public void listarJerarquiaTest() {

    }
}
