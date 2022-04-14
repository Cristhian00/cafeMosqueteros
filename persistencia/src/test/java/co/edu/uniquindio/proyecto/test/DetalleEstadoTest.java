package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.entidades.DetalleEstado;
import co.edu.uniquindio.proyecto.repositorios.DetalleEstadoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DetalleEstadoTest {

    @Autowired
    private DetalleEstadoRepo detalleEstadoRepo;

    @Test
    public void registrarDetalleEstadoTest(){

    }
    @Test
    public void eliminarDetalleEstadoTest(){
        DetalleCompra detalleCompra = new DetalleCompra();

    }
    @Test
    public void actualizarDetalleEstadoTest(){

    }
    @Test
    public void listarDetalleEstadoTest(){

    }
}
