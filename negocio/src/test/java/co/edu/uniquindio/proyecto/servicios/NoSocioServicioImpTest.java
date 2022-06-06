package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.NoSocio;
import co.edu.uniquindio.proyecto.repositorios.NoSocioRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:db-test.properties")
class NoSocioServicioImpTest {

    @MockBean
    private NoSocioRepo noSocioRepo;

    @Autowired
    private NoSocioServicio noSocioServicio;

    private NoSocio noSocio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        noSocio = new NoSocio("123456", "Diego", "Valencia",
                "diego@gmail.com", "3146326623", "diego123");
    }

    @Test
    void obtenerNoSocio() {
    }

    @Test
    void registrarNoSocio() {
    }

    @Test
    void actualizarNoSocio() {
    }

    @Test
    void eliminarNoSocio() {
    }

    @Test
    void listarNoSocio() {
        when(noSocioRepo.findAll()).thenReturn(Arrays.asList(noSocio));
        assertNotNull(noSocioServicio.listarNoSocio());
    }
}
