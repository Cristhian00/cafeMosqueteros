package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.TipoProducto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoTest {

    @Autowired
    private ProductoRepo productoRepo;

    private TipoProducto tipoProducto;

    @Test
    public void registrarProductoTest(){
        Producto producto = new Producto();
        producto.setIdProducto(2323);

        Producto guardado = productoRepo.save(producto);

        Assertions.assertNotNull(guardado);
    }

    @Test
    public void eliminarProductoTest(){

        Producto producto = new Producto();
        producto.setIdProducto(2323);
        Producto registrado = productoRepo.save(producto);

        productoRepo.delete(registrado);

        Producto buscado = productoRepo.findById(2323).orElse(null);
        Assertions.assertNotNull(buscado);

    }

    @Test
    public void actualizarProductoTest(){
        Producto producto = new Producto();
        producto.setIdProducto(2323);

        Producto registrado = productoRepo.save(producto);

        registrado.setPrecioVenta(40000);
        productoRepo.save(registrado);

        Producto buscado = productoRepo.findById(2323).orElse(null);
        Assertions.assertEquals("40000", buscado.getPrecioVenta());


    }
    @Test
    public void listarProductoTest(){
        List<Producto> lista = productoRepo.findAll();
        System.out.println(lista);
    }
}
