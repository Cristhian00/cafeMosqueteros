package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.EstadoCompra;
import co.edu.uniquindio.proyecto.repositorios.EstadoCompraRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EstadoCompraTest {
    @Autowired
    private EstadoCompraRepo estadoCompraRepo;

    @Test
    public void registrarEstadoCompraTest(){
        EstadoCompra estadoCompra = new EstadoCompra("La compra se encuentra en proceso de verificación");
        EstadoCompra guardado = estadoCompraRepo.save(estadoCompra);
        Assertions.assertNotNull(guardado);

    }

    @Test
    public void eliminarEstadoCompraTest(){
        EstadoCompra estadoCompra = new EstadoCompra("La compra se encuentra en proceso de verificación");
        EstadoCompra guardado = estadoCompraRepo.save(estadoCompra);

        estadoCompraRepo.delete(guardado);

        //HACER FIND REPOSITORIO

    }

    @Test
    public void actualizarEstadoCompraTest(){
        EstadoCompra estadoCompra = new EstadoCompra("La compra se encuentra en proceso de verificación");
        EstadoCompra guardado = estadoCompraRepo.save(estadoCompra);
        guardado.setDescripcion("La compra fue aprobada");
        estadoCompraRepo.save(guardado);
        //FIND HACER
    }
    @Test
    public void listarEstadoCompraTest(){

    }
}
