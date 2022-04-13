package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.NoSocio;
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
    public void registrarNoSocioTest(){
        NoSocio noSocio = new NoSocio();
        noSocio.setCedula("111");
        noSocio.setPrimerNombre("Diego");
        noSocio.setSegundoNombre("Mauricio");
        noSocio.setPrimerApellido("Valencia");
        noSocio.setSegundoApellido("Hernandez");
        noSocio.setCelular("3146237743");
        noSocio.setCorreo("diego@gmail.com");
        noSocio.setContrasenia("diego123");

        NoSocio guardado = noSocioRepo.save(noSocio);
        Assertions.assertNotNull(guardado);
    }
    @Test
    public void eliminarNoSocioTest(){
    NoSocio noSocio = new NoSocio();
        noSocio.setCedula("111");
        noSocio.setPrimerNombre("Diego");
        noSocio.setSegundoNombre("Mauricio");
        noSocio.setPrimerApellido("Valencia");
        noSocio.setSegundoApellido("Hernandez");
        noSocio.setCelular("3146237743");
        noSocio.setCorreo("diego@gmail.com");
        noSocio.setContrasenia("diego123");

        NoSocio registrado = noSocioRepo.save(noSocio);

        noSocioRepo.delete(registrado);

        NoSocio buscado = noSocioRepo.findById("111").orElse(null);
        Assertions.assertNotNull(buscado);


    }
    @Test
    public void actualizarNoSocioTest(){
        NoSocio noSocio = new NoSocio();
        noSocio.setCedula("111");
        noSocio.setPrimerNombre("Diego");
        noSocio.setSegundoNombre("Mauricio");
        noSocio.setPrimerApellido("Valencia");
        noSocio.setSegundoApellido("Hernandez");
        noSocio.setCelular("3146237743");
        noSocio.setCorreo("diego@gmail.com");
        noSocio.setContrasenia("diego123");

        NoSocio registrado = noSocioRepo.save(noSocio);

        registrado.setCelular("3206977325");
        noSocioRepo.save(registrado);
        NoSocio buscado = noSocioRepo.finById("111").orElse(null);
        Assertions.assertEquals("3206977325", buscado.getCelular());

    }
    @Test
    public void listarNoSocioTest(){
        List<NoSocio> lista = noSocioRepo.finAll();
        System.out.println(lista);
    }
}
