package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.EstadoSocio;
import co.edu.uniquindio.proyecto.entidades.Jerarquia;
import co.edu.uniquindio.proyecto.entidades.Promocion;
import co.edu.uniquindio.proyecto.entidades.Socio;

import co.edu.uniquindio.proyecto.repositorios.JerarquiaRepo;
import co.edu.uniquindio.proyecto.repositorios.PromocionRepo;
import co.edu.uniquindio.proyecto.repositorios.SocioRepo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SocioTest {

    @Autowired
    private SocioRepo socioRepo;
    @Autowired
    private PromocionRepo promocionRepo;
    @Autowired
    private JerarquiaRepo jerarquiaRepo;

    @Test
    public void registrarSocioTest() {
        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);

        Socio guardado = socioRepo.save(socio);
        Assertions.assertNotNull(guardado);
    }

    @Test
    public void eliminarSocioTest() {
        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);

        Socio guardado = socioRepo.save(socio);

        socioRepo.delete(guardado);
        Socio buscado = socioRepo.findById("123456").orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    public void actualizarSocioTest() {
        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);

        Socio guardado = socioRepo.save(socio);

        guardado.setCorreo("cristhian@gmail.com");
        socioRepo.save(guardado);

        Socio buscado = socioRepo.findById("123456").orElse(null);
        Assertions.assertEquals("cristhian@gmail.com", buscado.getCorreo());
    }

    @Test
    public void listarSocioTest() {
        List<Socio> lista = socioRepo.findAll();
        System.out.println(lista);

    }
}
