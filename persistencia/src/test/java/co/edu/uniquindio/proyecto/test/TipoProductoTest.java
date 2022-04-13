package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.TipoProducto;
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
    private ProductoRepo productoRepo;

    @Test
    public void registrarTipoProductoTest(){

        TipoProducto tipoProducto = new TipoProducto();
        List<Producto> productoList =  productoRepo.findAll();

        tipoProducto.setIdTipo(1);
        tipoProducto.setProductos(productoList);
        tipoProducto.setDescripcion("Los productos son hechos por empresas colombianas ");
        tipoProducto.setMedida(2.80);
        tipoProducto.setUnidadMedida("3");

        TipoProducto guardado = tipoProductoRepo.save(tipoProducto);
        Assertions.assertNotNull(guardado);
    }
    @Test
    public void eliminarTipoProductoTest(){

        TipoProducto tipoProducto = new TipoProducto();
        List<Producto> productoList =  productoRepo.findAll();

        tipoProducto.setIdTipo(1);
        tipoProducto.setProductos(productoList);
        tipoProducto.setDescripcion("Los productos son hechos por empresas colombianas ");
        tipoProducto.setMedida(2.80);
        tipoProducto.setUnidadMedida("3");

        TipoProducto registrado = tipoProductoRepo.save(tipoProducto);

        tipoProductoRepo.delete(registrado);
        TipoProducto buscado = productoRepo.findById(1).orElse(null);
        Assertions.assertNotNull(buscado);
    }
    @Test
    public void actualizarTipoProductoTest(){
        TipoProducto tipoProducto = new TipoProducto();
        List<Producto> productoList =  productoRepo.findAll();

        tipoProducto.setIdTipo(1);
        tipoProducto.setProductos(productoList);
        tipoProducto.setDescripcion("Cafe extra virgen");
        tipoProducto.setMedida(2.80);
        tipoProducto.setUnidadMedida("3");

        TipoProducto registrado = tipoProductoRepo.save(tipoProducto);
        registrado.setMedida(4.3);

        TipoProducto buscado = productoRepo.findById(1).orElse(null);
        Assertions.assertEquals(4.3,buscado.getMedida());

    }
    @Test
    public void listarTipoProductoTest(){
        List<TipoProducto> lista = tipoProductoRepo.findAll();
        System.out.println(lista);

    }
}
