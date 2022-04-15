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

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoTest {

    @Autowired
    private ProductoRepo productoRepo;
    @Autowired
    private TipoProductoRepo tipoProductoRepo;

    @Test
    public void registrarProductoTest() {
        TipoProducto tipoProducto = new TipoProducto("Molido", "mg", 500);
        tipoProductoRepo.save(tipoProducto);

        Producto producto = new Producto("cafe aroma vainilla", "Café con toques sueves de vainilla", 35.000, 25.000, 30, tipoProducto);
        Producto guardado = productoRepo.save(producto);

        Assertions.assertNotNull(guardado);
    }

    @Test
    public void eliminarProductoTest() {

        TipoProducto tipoProducto = new TipoProducto("Molido", "mg", 500);
        tipoProductoRepo.save(tipoProducto);

        Producto producto = new Producto("cafe aroma vainilla", "Café con toques sueves de vainilla", 35.000, 25.000, 30, tipoProducto);
        Producto guardado = productoRepo.save(producto);

        productoRepo.delete(guardado);
        Producto buscado = productoRepo.findById(1).orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    public void actualizarProductoTest() {
        TipoProducto tipoProducto = new TipoProducto("Molido", "mg", 500);
        tipoProductoRepo.save(tipoProducto);

        Producto producto = new Producto("cafe aroma vainilla", "Café con toques sueves de vainilla",
                35000, 25.000, 30, tipoProducto);
        Producto guardado = productoRepo.save(producto);


        guardado.setPrecioVenta(40000);
        productoRepo.save(guardado);
        Producto buscado = productoRepo.findById(1).orElse(null);
        Assertions.assertEquals(40000, buscado.getPrecioVenta());
    }

    @Test
    public void listarProductoTest() {
        List<Producto> lista = productoRepo.findAll();
        System.out.println(lista);
    }
}
