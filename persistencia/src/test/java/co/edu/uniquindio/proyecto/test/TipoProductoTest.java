package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.TipoProducto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.TipoProductoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TipoProductoTest {

    @Autowired
    private TipoProductoRepo tipoProductoRepo;

    @Test
    public void registrarTipoProductoTest(){

        TipoProducto tipoProducto = new TipoProducto("Envase no retornable", "ml", 360);
        TipoProducto guardado = tipoProductoRepo.save(tipoProducto);

        Assertions.assertNotNull(guardado);
    }
    @Test
    public void eliminarTipoProductoTest(){

        TipoProducto tipoProducto = new TipoProducto();

        tipoProducto.setIdTipo(1);
        tipoProducto.setDescripcion("Los productos son hechos por empresas colombianas ");
        tipoProducto.setMedida(2.80);
        tipoProducto.setUnidadMedida("3");

        TipoProducto registrado = tipoProductoRepo.save(tipoProducto);

        tipoProductoRepo.delete(registrado);
        TipoProducto buscado = tipoProductoRepo.findById(1).orElse(null);
        Assertions.assertNull(buscado);
    }
    @Test
    public void actualizarTipoProductoTest(){
        TipoProducto tipoProducto = new TipoProducto();

        tipoProducto.setIdTipo(1);
        tipoProducto.setDescripcion("Cafe extra virgen");
        tipoProducto.setMedida(2.80);
        tipoProducto.setUnidadMedida("3");

        TipoProducto registrado = tipoProductoRepo.save(tipoProducto);
        registrado.setMedida(4.3);

        TipoProducto buscado = tipoProductoRepo.findById(1).orElse(null);
        Assertions.assertEquals(4.3,buscado.getMedida());

    }
    @Test
    public void listarTipoProductoTest(){
        List<TipoProducto> lista = tipoProductoRepo.findAll();
        System.out.println(lista);
    }
}
