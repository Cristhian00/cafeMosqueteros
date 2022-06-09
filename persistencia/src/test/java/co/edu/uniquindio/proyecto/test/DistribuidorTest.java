package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Distribuidor;
import co.edu.uniquindio.proyecto.repositorios.DistribuidorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DistribuidorTest {
    @Autowired
    private DistribuidorRepo distribuidorRepo;

    @Test
    public void registrarDistribuidorTest() {
        Distribuidor distribuidor = new Distribuidor("2121", "Carlos Martinez", "Armenia");
        Distribuidor guardado = distribuidorRepo.save(distribuidor);
        Assertions.assertNotNull(guardado);
    }

    @Test
    public void eliminarDistribuidorTest() {
        Distribuidor distribuidor = new Distribuidor("2121", "Carlos Martinez", "Armenia");
        Distribuidor guardado = distribuidorRepo.save(distribuidor);
        //Luego se elimina
        distribuidorRepo.delete(guardado);

        Distribuidor buscado = distribuidorRepo.findById(distribuidor.getNitDistribuidor()).orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    public void actualizarDistribuidorTest() {
        Distribuidor distribuidor = new Distribuidor("2121", "Carlos Martinez", "Armenia");
        Distribuidor guardado = distribuidorRepo.save(distribuidor);

        guardado.setNombre("Carlos Hernandez");

        distribuidorRepo.save(guardado);

        Distribuidor buscado = distribuidorRepo.findById(distribuidor.getNitDistribuidor()).orElse(null);
        Assertions.assertEquals("Carlos Hernandez", buscado.getNombre());
    }

    @Test
    public void listarDistribuidorTest() {
        List<Distribuidor> lista = distribuidorRepo.findAll();
        System.out.println(lista);

    }
}
