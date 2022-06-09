package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class InventarioTest {

    @Autowired
    private InventarioRepo inventarioRepo;
    @Autowired
    private PromocionRepo promocionRepo;
    @Autowired
    private JerarquiaRepo jerarquiaRepo;
    @Autowired
    private SocioRepo socioRepo;
    @Autowired
    private TipoProductoRepo tipoProductoRepo;
    @Autowired
    private ProductoRepo productoRepo;

    @Test
    public void registrarInventarioTest() {

        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);
        socioRepo.save(socio);

        TipoProducto tipoProducto = new TipoProducto("Cafe 100% colombiano", "300", 38.56);
        tipoProductoRepo.save(tipoProducto);

        Producto producto = new Producto("café mosqueteros molido", "Cafe molido", 35.000, 25.000, 20, tipoProducto);
        productoRepo.save(producto);

        Inventario inventario = new Inventario(50, socio, producto);
        Inventario guardado = inventarioRepo.save(inventario);

        Assertions.assertNotNull(guardado);
    }

    @Test
    public void eliminarInventarioTest() {
        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);
        socioRepo.save(socio);

        TipoProducto tipoProducto = new TipoProducto("Cafe 100% colombiano", "300", 38.56);
        tipoProductoRepo.save(tipoProducto);

        Producto producto = new Producto("café mosqueteros molido", "Cafe molido", 35.000, 25.000, 20, tipoProducto);
        productoRepo.save(producto);

        Inventario inventario = new Inventario(50, socio, producto);
        Inventario guardado = inventarioRepo.save(inventario);

        inventarioRepo.delete(guardado);
        Inventario buscado = inventarioRepo.obtenerSocioInventarioAndProductoInventario(socio, producto);
        Assertions.assertNull(buscado);
    }

    @Test
    public void actualizarInventarioTest() {
        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);
        socioRepo.save(socio);

        TipoProducto tipoProducto = new TipoProducto("Cafe 100% colombiano", "300", 38.56);
        tipoProductoRepo.save(tipoProducto);

        Producto producto = new Producto("café mosqueteros molido", "Cafe molido", 35.000, 25.000, 20, tipoProducto);
        productoRepo.save(producto);

        Inventario inventario = new Inventario(50, socio, producto);
        Inventario guardado = inventarioRepo.save(inventario);

        guardado.setCantidad(70);

        inventarioRepo.save(guardado);
        Inventario buscado = inventarioRepo.obtenerSocioInventarioAndProductoInventario(socio, producto);
        Assertions.assertEquals(70, buscado.getCantidad());
    }

    @Test
    public void listarInventarioTest() {
        List<Inventario> lista = inventarioRepo.findAll();
        System.out.println(lista);
    }
}
