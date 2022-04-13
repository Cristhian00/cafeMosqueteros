package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Distribuidor;
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
    public void registrarDistribuidorTest(){
        Distribuidor distribuidor = new Distribuidor();
        distribuidor.setNitDistribuidor("12345");
        distribuidor.setNombre("Ernesto Perez");
        distribuidor.setCiudad("Armenia");

        Distribuidor guardado = distribuidorRepo.save(distribuidor);
        Assertions.assertNotNull(guardado);
    }

    @Test
    public void eliminarDistribuidorTest(){
    Distribuidor distribuidor = new Distribuidor();
    distribuidor.setNitDistribuidor("12345");
    distribuidor.setNombre("Ernesto Perez");
    distribuidor.setCiudad("Armenia");

    //Primero se guarda
    Distribuidor registrado = distribuidorRepo.save(distribuidor);

    //Luego se elimina
    distribuidorRepo.delete(registrado);

    //Por ultimo, Se verifica que si haya quedado borrado
    Distribuidor buscado = distribuidorRepo.findById("12345").orElse(null);
    Assertions.assertNotNull(buscado);

    }
    @Test
    public void actualizarDistribuidorTest(){
     Distribuidor distribuidor = new Distribuidor();
     distribuidor.setNitDistribuidor("12345");
     distribuidor.setNombre("Ernesto Perez");
     distribuidor.setCiudad("Armenia");

     Distribuidor registrado = distribuidorRepo.save(distribuidor);

     registrado.setNombre("Carlos Valencia");


     distribuidorRepo.save(registrado);

     Distribuidor buscado = distribuidorRepo.findById("12345").orElse(null);
     Assertions.assertEquals("Carlos Valencia", buscado.getNombre());

    }
    @Test
    public void listarDistribuidorTest(){
        List<Distribuidor> lista = distribuidorRepo.findAll();

        System.out.println(lista);

    }
}
