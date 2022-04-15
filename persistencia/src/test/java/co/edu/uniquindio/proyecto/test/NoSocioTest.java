package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.NoSocio;
import co.edu.uniquindio.proyecto.repositorios.NoSocioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NoSocioTest {

    @Autowired
    private NoSocioRepo noSocioRepo;

    @Test
    public void registrarNoSocioTest() {
        NoSocio noSocio = new NoSocio("123456", "Diego", "Valencia",
                "diego@gmail.com", "3146326623", "diego123");
        NoSocio guardado = noSocioRepo.save(noSocio);
        Assertions.assertNotNull(guardado);
    }

    @Test
    public void eliminarNoSocioTest() {
        NoSocio noSocio = new NoSocio("123456", "Diego", "Valencia", "diego@gmail.com", "3146326623", "diego123");
        NoSocio guardado = noSocioRepo.save(noSocio);

        noSocioRepo.delete(guardado);
        NoSocio buscado = noSocioRepo.findById("123456").orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    public void actualizarNoSocioTest() {
        NoSocio noSocio = new NoSocio("123456", "Diego", "Valencia",
                "diego@gmail.com", "3146326623", "diego123");
        NoSocio guardado = noSocioRepo.save(noSocio);

        guardado.setCelular("3147327723");
        noSocioRepo.save(guardado);

        NoSocio buscado = noSocioRepo.findById("123456").orElse(null);
        Assertions.assertEquals("3147327723", buscado.getCelular());
    }

    @Test
    public void listarNoSocioTest() {
        List<NoSocio> lista = noSocioRepo.findAll();
        System.out.println(lista);
    }
}
