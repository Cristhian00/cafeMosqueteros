package co.edu.uniquindio.proyecto.config;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class InformacionPorDefecto implements CommandLineRunner {

    @Autowired
    private AdministradorServicio adminServicio;

    @Autowired
    private CompraServicio compraServicio;

    @Autowired
    private DetalleCompraServicio detalleCompraServicio;

    @Autowired
    private DetalleEstadoServicio detalleEstadoServicio;

    @Autowired
    private DetallePedidoServicio detallePedidoServicio;

    @Autowired
    private DistribuidorServicio distribuidorServicio;

    @Autowired
    private EstadoCompraServicio estadoCompraServicio;

    @Autowired
    private GananciaServicio gananciaServicio;

    @Autowired
    private HistorialJerarquiaServicio historialJerarquiaServicio;

    @Autowired
    private InventarioServicio inventarioServicio;

    @Autowired
    private JerarquiaServicio jerarquiaServicio;

    @Autowired
    private NivelServicio nivelServicio;

    @Autowired
    private NoSocioServicio noSocioServicio;

    @Autowired
    private PedidoServicio pedidoServicio;

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private PromocionServicio promocionServicio;

    @Autowired
    private SocioServicio socioServicio;

    @Autowired
    private TipoProductoServicio tipoProductoServicio;

    @Override
    public void run(String... args) throws Exception {

        if (promocionServicio.listarPromocion().isEmpty()) {
            Promocion promocion1 = new Promocion("Viaje a Cocora", 0.15);
            promocionServicio.registrarPromocion(promocion1);

            Promocion promocion2 = new Promocion("Viaje San Andres", 0.2);
            promocionServicio.registrarPromocion(promocion2);
        }

        if (jerarquiaServicio.listarJerarquia().isEmpty()) {
            Promocion promo1 = promocionServicio.obtenerPromocion(1);
            Promocion promo2 = promocionServicio.obtenerPromocion(2);
            Jerarquia jerarquia1 = new Jerarquia("Bronce", 2, 20000, promo1);
            Jerarquia jerarquia2 = new Jerarquia("Plata", 5, 50000, promo1);
            Jerarquia jerarquia3 = new Jerarquia("Oro", 8, 80000, promo2);
            Jerarquia jerarquia4 = new Jerarquia("Diamante", 12, 120000, promo2);
            jerarquiaServicio.registrarJerarquia(jerarquia1);
            jerarquiaServicio.registrarJerarquia(jerarquia2);
            jerarquiaServicio.registrarJerarquia(jerarquia3);
            jerarquiaServicio.registrarJerarquia(jerarquia4);
        }

        if (socioServicio.listarSocio().isEmpty()) {
            Jerarquia jera1 = jerarquiaServicio.obtenerJerarquia("Bronce");
            Jerarquia jera2 = jerarquiaServicio.obtenerJerarquia("Plata");
            Jerarquia jera3 = jerarquiaServicio.obtenerJerarquia("Oro");
            Jerarquia jera4 = jerarquiaServicio.obtenerJerarquia("Diamante");
            Socio socio1 = new Socio("123456", "Cristhian", "Ortiz", "cris@gmail.com",
                    "3124323434", "socio", new Date(), EstadoSocio.ACTIVO, null, jera4);
            Socio socio2 = new Socio("654321", "Diego", "Valencia", "diego@gmail.com",
                    "3124323490", "socio", new Date(), EstadoSocio.PENDIENTE, socio1, jera1);
            Socio socio3 = new Socio("233445", "Tatiana", "Arboleda", "tata@gmail.com",
                    "3120003434", "socio", new Date(), EstadoSocio.ACTIVO, socio1, jera2);
            Socio socio4 = new Socio("122334", "Carolina", "Serna", "caro@gmail.com",
                    "3109323434", "socio", new Date(), EstadoSocio.ACTIVO, socio2, jera3);
            Socio socio5 = new Socio("098765", "Yulie", "Martinez", "yulie@gmail.com",
                    "3124399434", "socio", new Date(), EstadoSocio.ACTIVO, socio2, jera2);
            Socio socio6 = new Socio("125689", "Alejandro", "Murillo", "alejo@gmail.com",
                    "3209879898", "socio", new Date(), EstadoSocio.ACTIVO, socio1, jera1);
            Socio socio7 = new Socio("102938", "Pablo", "Leal", "pablo@gmail.com",
                    "3124329999", "socio", new Date(), EstadoSocio.ACTIVO, socio3, jera1);
            socioServicio.registrarSocio(socio1);
            socioServicio.registrarSocio(socio2);
            socioServicio.registrarSocio(socio3);
            socioServicio.registrarSocio(socio4);
            socioServicio.registrarSocio(socio5);
            socioServicio.registrarSocio(socio6);
            socioServicio.registrarSocio(socio7);
        }
        if (compraServicio.listarCompra().isEmpty()) {
            Socio socio1 = socioServicio.obtenerSocio("123456");
            Socio socio2 = socioServicio.obtenerSocio("122334");
            Socio socio3 = socioServicio.obtenerSocio("098765");
            Compra c1 = new Compra(new Date(), 90000, socio1, null);
            Compra c2 = new Compra(new Date(), 20000, socio2, null);
            Compra c3 = new Compra(new Date(), 30000, socio3, null);
            Compra c4 = new Compra(new Date(), 120000, socio1, null);
            Compra c5 = new Compra(new Date(), 45000, socio1, null);
            Compra c6 = new Compra(new Date(), 34000, socio2, null);
            compraServicio.registrarCompra(c1);
            compraServicio.registrarCompra(c2);
            compraServicio.registrarCompra(c3);
            compraServicio.registrarCompra(c4);
            compraServicio.registrarCompra(c5);
            compraServicio.registrarCompra(c6);
        }

    }
}
