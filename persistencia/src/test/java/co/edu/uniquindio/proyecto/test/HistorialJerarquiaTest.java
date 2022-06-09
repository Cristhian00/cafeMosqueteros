package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.HistorialJerarquiaRepo;
import co.edu.uniquindio.proyecto.repositorios.JerarquiaRepo;
import co.edu.uniquindio.proyecto.repositorios.PromocionRepo;
import co.edu.uniquindio.proyecto.repositorios.SocioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HistorialJerarquiaTest {

    @Autowired
    private HistorialJerarquiaRepo historialJerarquiaRepo;
    @Autowired
    private PromocionRepo promocionRepo;
    @Autowired
    private JerarquiaRepo jerarquiaRepo;
    @Autowired
    private SocioRepo socioRepo;

    @Test
    public void registrarHistorialJerarquiaTest() {

        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);
        socioRepo.save(socio);

        HistorialJerarquia historialJerarquia = new HistorialJerarquia(new Date(), new Date(), socio, jerarquia);
        HistorialJerarquia guardado = historialJerarquiaRepo.save(historialJerarquia);

        Assertions.assertNotNull(guardado);
    }

    @Test
    public void eliminarHistorialJerarquiaTest() {
        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);
        socioRepo.save(socio);

        HistorialJerarquia historialJerarquia = new HistorialJerarquia(new Date(), new Date(), socio, jerarquia);
        HistorialJerarquia guardado = historialJerarquiaRepo.save(historialJerarquia);

        historialJerarquiaRepo.delete(guardado);
        HistorialJerarquia buscado = historialJerarquiaRepo.findBySocioHistorialAndJerarquiahistorial(socio, jerarquia);
        Assertions.assertNull(buscado);
    }

    @Test
    public void actualizarHistorialJerarquiaTest() {
        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);
        socioRepo.save(socio);

        HistorialJerarquia historialJerarquia = new HistorialJerarquia(new Date(), new Date(), socio, jerarquia);
        HistorialJerarquia guardado = historialJerarquiaRepo.save(historialJerarquia);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date fecha = sdf.parse("2021/04/15");
            guardado.setFechaInicio(fecha);
            historialJerarquiaRepo.save(guardado);

            HistorialJerarquia buscado = historialJerarquiaRepo.findBySocioHistorialAndJerarquiahistorial(socio, jerarquia);
            Assertions.assertEquals(fecha, buscado.getFechaInicio());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listarHistorialJerarquiaTest() {

    }
}
