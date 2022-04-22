package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DetalleEstadoTest {

    @Autowired
    private DetalleEstadoRepo detalleEstadoRepo;
    @Autowired
    private EstadoCompraRepo estadoCompraRepo;
    @Autowired
    private CompraRepo compraRepo;
    @Autowired
    private SocioRepo socioRepo;
    @Autowired
    private PromocionRepo promocionRepo;
    @Autowired
    private JerarquiaRepo jerarquiaRepo;

    @Test
    public void registrarDetalleEstadoTest() {

        EstadoCompra estadoCompra = new EstadoCompra("PENDIENTE");
        estadoCompraRepo.save(estadoCompra);

        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);
        socioRepo.save(socio);

        Compra compra = new Compra(new Date(), 39.900, socio, null);
        compraRepo.save(compra);

        DetalleEstado detalleEstado = new DetalleEstado(new Date(), estadoCompra, compra);
        DetalleEstado guardado = detalleEstadoRepo.save(detalleEstado);

        //Comprobamos que si haya quedado
        Assertions.assertNotNull(guardado);
    }

    @Test
    public void eliminarDetalleEstadoTest() {
        EstadoCompra estadoCompra = new EstadoCompra("El producto esta pago");
        estadoCompraRepo.save(estadoCompra);

        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);
        socioRepo.save(socio);

        Compra compra = new Compra(new Date(), 39.900, socio, null);
        compraRepo.save(compra);

        DetalleEstado detalleEstado = new DetalleEstado(new Date(), estadoCompra, compra);
        DetalleEstado guardado = detalleEstadoRepo.save(detalleEstado);

        detalleEstadoRepo.delete(guardado);
        DetalleEstado buscar = detalleEstadoRepo.findByCompraEstadoAndEstadoDetalle(compra, estadoCompra);

        Assertions.assertNull(buscar);
    }

    @Test
    public void actualizarDetalleEstadoTest() {

        EstadoCompra estadoCompra = new EstadoCompra("El producto esta pago");
        estadoCompraRepo.save(estadoCompra);

        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);
        socioRepo.save(socio);

        Compra compra = new Compra(new Date(), 39.900, socio, null);
        compraRepo.save(compra);

        DetalleEstado detalleEstado = new DetalleEstado(new Date(), estadoCompra, compra);
        DetalleEstado guardado = detalleEstadoRepo.save(detalleEstado);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date fecha = sdf.parse("2021/04/15");
            guardado.setFecha(fecha);

            detalleEstadoRepo.save(guardado);
            DetalleEstado buscado = detalleEstadoRepo.findByCompraEstadoAndEstadoDetalle(compra, estadoCompra);
            Assertions.assertEquals(fecha, buscado.getFecha());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listarDetalleEstadoTest() {

    }
}
