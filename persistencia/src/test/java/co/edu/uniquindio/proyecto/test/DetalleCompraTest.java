package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DetalleCompraTest {

    @Autowired
    private DetalleCompraRepo detalleCompraRepo;

    @Autowired
    private CompraRepo compraRepo;

    @Autowired
    private SocioRepo socioRepo;

    @Autowired
    private JerarquiaRepo jerarquiaRepo;

    @Autowired
    private PromocionRepo promocionRepo;

    @Autowired
    private TipoProductoRepo tipoProductoRepo;

    @Autowired
    private ProductoRepo productoRepo;

    @Test
    public void registrarDetalleCompraTest() {
        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);
        socioRepo.save(socio);

        Compra compra = new Compra(socio, null, EstadoCompra.PENDIENTE);
        compraRepo.save(compra);

        TipoProducto tipoProducto = new TipoProducto("Envase no retornable", "ml", 360);
        tipoProductoRepo.save(tipoProducto);

        Producto producto = new Producto("Café molido", "Café gourmet",
                10000, 5000, 20, tipoProducto);
        productoRepo.save(producto);

        DetalleCompra detalle = new DetalleCompra(3, 2000, producto, compra);
        DetalleCompra guardada = detalleCompraRepo.save(detalle);

        //Comprobamos que si haya quedado
        Assertions.assertNotNull(guardada);
    }

    @Test
    public void eliminarDetalleCompraTest() {
        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);
        socioRepo.save(socio);

        Compra compra = new Compra(socio, null, EstadoCompra.PENDIENTE);
        compraRepo.save(compra);

        TipoProducto tipoProducto = new TipoProducto("Envase no retornable", "ml", 360);
        tipoProductoRepo.save(tipoProducto);

        Producto producto = new Producto("Café molido", "Café gourmet",
                10000, 5000, 20, tipoProducto);
        productoRepo.save(producto);

        DetalleCompra detalle = new DetalleCompra(3, 2000, producto, compra);
        //Primero lo guardamos
        DetalleCompra guardada = detalleCompraRepo.save(detalle);

        //Luego lo eliminamos
        detalleCompraRepo.delete(guardada);
        //Por último, verificamos que si haya quedado borrado
        DetalleCompra buscado = detalleCompraRepo.findByProductoDetalleAndCompraDetalle(producto, compra);

        Assertions.assertNull(buscado);
    }

    @Test
    public void actualizarCompraTest() {
        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);
        socioRepo.save(socio);

        Compra compra = new Compra(socio, null, EstadoCompra.PENDIENTE);
        compraRepo.save(compra);

        TipoProducto tipoProducto = new TipoProducto("Envase no retornable", "ml", 360);
        tipoProductoRepo.save(tipoProducto);

        Producto producto = new Producto("Café molido", "Café gourmet",
                10000, 5000, 20, tipoProducto);
        productoRepo.save(producto);

        DetalleCompra detalle = new DetalleCompra(3, 2000, producto, compra);
        //Primero lo guardamos
        DetalleCompra guardada = detalleCompraRepo.save(detalle);

        //Modificamos el total
        guardada.setCantidad(10);

        //Con save guardamos el registro modificado
        detalleCompraRepo.save(guardada);

        //Por último, verificamos que si haya quedado actualizado
        DetalleCompra buscado = detalleCompraRepo.findByProductoDetalleAndCompraDetalle(producto, compra);
        Assertions.assertEquals(10, buscado.getCantidad());
    }

    @Test
    public void listarDetalleCompraTest() {

    }
}
