package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.JerarquiaRepo;
import co.edu.uniquindio.proyecto.repositorios.PromocionRepo;
import co.edu.uniquindio.proyecto.repositorios.SocioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompraTest {

    @Autowired
    private CompraRepo compraRepo;

    @Autowired
    private SocioRepo socioRepo;

    @Autowired
    private JerarquiaRepo jerarquiaRepo;

    @Autowired
    private PromocionRepo promocionRepo;

    @Test
    public void registrarCompraTest() {

        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);
        socioRepo.save(socio);

        Compra c = new Compra(socio, null, EstadoCompra.PENDIENTE);
        Compra guardada = compraRepo.save(c);

        //Comprobamos que si haya quedado
        Assertions.assertNotNull(guardada);
    }

    @Test
    public void eliminarCompraTest() {

        Promocion promocion = new Promocion("Viaje a Cocora", 0.3);
        promocionRepo.save(promocion);

        Jerarquia jerarquia = new Jerarquia("Bronce", 5, 10000, promocion);
        jerarquiaRepo.save(jerarquia);

        Socio socio = new Socio("123456", "Cristhian", "Ortiz", "Cris@mail.com",
                "312432", "admin", new Date(), EstadoSocio.ACTIVO, null, jerarquia);
        socioRepo.save(socio);

        Compra c = new Compra(socio, null, EstadoCompra.PENDIENTE);
        //Primero lo guardamos
        Compra guardada = compraRepo.save(c);

        //Luego lo eliminamos
        compraRepo.delete(guardada);
        //Por último, verificamos que si haya quedado borrado
        Compra buscado = compraRepo.findById(1).orElse(null);
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

        Compra c = new Compra(socio, null, EstadoCompra.PENDIENTE);
        //Primero lo guardamos
        Compra guardada = compraRepo.save(c);

        //Modificamos el total
        guardada.setTotal(50000);

        //Con save guardamos el registro modificado
        compraRepo.save(guardada);

        //Por último, verificamos que si haya quedado actualizado
        Compra buscado = compraRepo.findById(1).orElse(null);
        Assertions.assertEquals(50000, buscado.getTotal());
    }

    @Test
    public void listarCompraTest() {
        //Obtenemos la lista de todos los usuarios
        List<Compra> lista = compraRepo.findAll();
        //Imprimimos la lista
        System.out.println(lista);
    }
}
