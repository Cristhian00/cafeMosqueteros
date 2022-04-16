package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.GananciaRepo;
import co.edu.uniquindio.proyecto.repositorios.JerarquiaRepo;
import co.edu.uniquindio.proyecto.repositorios.PromocionRepo;
import co.edu.uniquindio.proyecto.repositorios.SocioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GananciaTest {

    @Autowired
    private GananciaRepo gananciaRepo;

    @Autowired
    private SocioRepo socioRepo;

    @Autowired
    private PromocionRepo promocionRepo;

    @Autowired
    private JerarquiaRepo jerarquiaRepo;

    @Test
    public void registrarGananciaTest() {
        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);
        socioRepo.save(socio);

        Ganancia ganancia = new Ganancia(100.000, 2021, "noviembre", socio);
        Ganancia guardar = gananciaRepo.save(ganancia);

        Assertions.assertNotNull(guardar);
    }

    @Test
    public void eliminarGananciaTest() {
        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);
        socioRepo.save(socio);

        Ganancia ganancia = new Ganancia(100.000, 2021, "Noviembre", socio);
        Ganancia guardar = gananciaRepo.save(ganancia);

        gananciaRepo.delete(guardar);

        Ganancia buscado = gananciaRepo.findBySocioGananciaAndAnioAndMes(socio, 2021, "Noviembre");
        Assertions.assertNull(buscado);
    }

    @Test
    public void actualizarGananciaTest() {
        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);
        socioRepo.save(socio);

        Ganancia ganancia = new Ganancia(100000, 2021, "noviembre", socio);
        Ganancia guardar = gananciaRepo.save(ganancia);

        guardar.setGanancias(50000);

        gananciaRepo.save(guardar);

        Ganancia buscado = gananciaRepo.findBySocioGananciaAndAnioAndMes(socio, 2021, "Noviembre");
        Assertions.assertEquals(50000, buscado.getGanancias());
    }

    @Test
    public void listarGananciaTest() {

    }
}
