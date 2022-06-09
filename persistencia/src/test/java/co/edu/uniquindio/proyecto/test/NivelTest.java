package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Nivel;
import co.edu.uniquindio.proyecto.repositorios.NivelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NivelTest {

    @Autowired
    private NivelRepo nivelRepo;

    @Test
    public void registrarNivelTest() {
        Nivel nivel = new Nivel(2, 2.5);
        Nivel guardado = nivelRepo.save(nivel);
        Assertions.assertNotNull(guardado);
    }

    @Test
    public void eliminarNivelTest() {
        Nivel nivel = new Nivel(2, 2.5);
        Nivel guardado = nivelRepo.save(nivel);

        nivelRepo.delete(guardado);
        Nivel buscado = nivelRepo.findById(2).orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    public void actualizarNivelTest() {
        Nivel nivel = new Nivel(2, 2.5);
        Nivel guardado = nivelRepo.save(nivel);

        guardado.setComision(2.0);

        nivelRepo.save(guardado);
        Nivel buscado = nivelRepo.findById(2).orElse(null);
        Assertions.assertEquals(2.0, buscado.getComision());
    }

    @Test
    public void listarNivelTest() {

    }
}
