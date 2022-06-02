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
    private DetallePedidoServicio detallePedidoServicio;

    @Autowired
    private DistribuidorServicio distribuidorServicio;

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
        if(adminServicio.obtenerAdministrador().isEmpty()){
            Administrador administrador = new Administrador("admin@gmail.com","admin");
            adminServicio.registrarAdministrador(administrador);
        }

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

        if (productoServicio.listarProducto().isEmpty()) {
            TipoProducto tipo1 = new TipoProducto("Enlatado", "ml", 350);
            TipoProducto tipo2 = new TipoProducto("Molido", "gr", 500);
            TipoProducto tipo3 = new TipoProducto("Grano", "lb", 2);
            TipoProducto tipo4 = new TipoProducto("Dulce", "gr", 50);
            tipoProductoServicio.registrarTipoProducto(tipo1);
            tipoProductoServicio.registrarTipoProducto(tipo2);
            tipoProductoServicio.registrarTipoProducto(tipo3);
            tipoProductoServicio.registrarTipoProducto(tipo4);

            Producto producto1 = new Producto("CafeYa", "Bebida energizante", 5000,
                    2400, 50, tipo1);
            Producto producto2 = new Producto("Cafe gourmet", "Café molido gourmet", 35000,
                    20000, 30, tipo2);
            Producto producto3 = new Producto("Cafe de Montenegro", "Café en grano de Monteblack", 30000,
                    17000, 40, tipo3);
            Producto producto4 = new Producto("Arequipe de cafe", "Dulce de arequipe con café", 10000,
                    6500, 70, tipo4);
            productoServicio.registrarProducto(producto1);
            productoServicio.registrarProducto(producto2);
            productoServicio.registrarProducto(producto3);
            productoServicio.registrarProducto(producto4);
        }

        if (compraServicio.listarCompra().isEmpty()) {
            Socio socio1 = socioServicio.obtenerSocio("123456");
            Socio socio2 = socioServicio.obtenerSocio("122334");
            Socio socio3 = socioServicio.obtenerSocio("098765");
            socio1.setEstado(EstadoSocio.ACTIVO);
            socio2.setEstado(EstadoSocio.ACTIVO);
            socio3.setEstado(EstadoSocio.ACTIVO);
            socioServicio.actualizarSocio(socio1);
            socioServicio.actualizarSocio(socio2);
            socioServicio.actualizarSocio(socio3);

            Compra c1 = new Compra(socio1, null, EstadoCompra.PENDIENTE);
            Compra c2 = new Compra(socio2, null, EstadoCompra.PENDIENTE);
            Compra c3 = new Compra(socio3, null, EstadoCompra.PENDIENTE);
            Compra c4 = new Compra(socio1, null, EstadoCompra.PENDIENTE);
            Compra c5 = new Compra(socio1, null, EstadoCompra.PENDIENTE);
            Compra c6 = new Compra(socio2, null, EstadoCompra.PENDIENTE);

            compraServicio.registrarCompra(c1);
            compraServicio.registrarCompra(c2);
            compraServicio.registrarCompra(c3);
            compraServicio.registrarCompra(c4);
            compraServicio.registrarCompra(c5);
            compraServicio.registrarCompra(c6);

            Producto p1 = productoServicio.obtenerProducto(1);
            Producto p2 = productoServicio.obtenerProducto(2);
            Producto p3 = productoServicio.obtenerProducto(3);
            Producto p4 = productoServicio.obtenerProducto(4);

            DetalleCompra detalleCompra1_1 = new DetalleCompra(3, p1.getPrecioVenta(), p1, c1);
            DetalleCompra detalleCompra1_2 = new DetalleCompra(5, p2.getPrecioVenta(), p2, c1);
            DetalleCompra detalleCompra1_3 = new DetalleCompra(5, p3.getPrecioVenta(), p3, c1);
            DetalleCompra detalleCompra2_1 = new DetalleCompra(2, p1.getPrecioVenta(), p1, c2);
            DetalleCompra detalleCompra2_2 = new DetalleCompra(5, p2.getPrecioVenta(), p2, c2);
            DetalleCompra detalleCompra2_3 = new DetalleCompra(2, p3.getPrecioVenta(), p3, c2);
            DetalleCompra detalleCompra3_1 = new DetalleCompra(5, p1.getPrecioVenta(), p1, c3);
            DetalleCompra detalleCompra3_2 = new DetalleCompra(10, p4.getPrecioVenta(), p4, c3);
            DetalleCompra detalleCompra4_1 = new DetalleCompra(8, p4.getPrecioVenta(), p4, c5);
            DetalleCompra detalleCompra4_2 = new DetalleCompra(6, p2.getPrecioVenta(), p2, c5);
            DetalleCompra detalleCompra4_3 = new DetalleCompra(10, p3.getPrecioVenta(), p3, c5);

            detalleCompraServicio.registrarDetalleCompra(detalleCompra1_1);
            detalleCompraServicio.registrarDetalleCompra(detalleCompra1_2);
            detalleCompraServicio.registrarDetalleCompra(detalleCompra1_3);
            detalleCompraServicio.registrarDetalleCompra(detalleCompra2_1);
            detalleCompraServicio.registrarDetalleCompra(detalleCompra2_2);
            detalleCompraServicio.registrarDetalleCompra(detalleCompra2_3);
            detalleCompraServicio.registrarDetalleCompra(detalleCompra3_1);
            detalleCompraServicio.registrarDetalleCompra(detalleCompra3_2);
            detalleCompraServicio.registrarDetalleCompra(detalleCompra4_1);
            detalleCompraServicio.registrarDetalleCompra(detalleCompra4_2);
            detalleCompraServicio.registrarDetalleCompra(detalleCompra4_3);

            compraServicio.actualizarEstadoCompra(c1.getIdCompra(), EstadoCompra.APROBADA);
            compraServicio.actualizarEstadoCompra(c2.getIdCompra(), EstadoCompra.APROBADA);
            compraServicio.actualizarEstadoCompra(c3.getIdCompra(), EstadoCompra.APROBADA);
            compraServicio.actualizarEstadoCompra(c5.getIdCompra(), EstadoCompra.APROBADA);
        }

        if (detalleCompraServicio.listarDetalleCompra().isEmpty()) {
            Compra compra1 = compraServicio.obtenerCompra(1);
            Compra compra2 = compraServicio.obtenerCompra(2);
            Compra compra3 = compraServicio.obtenerCompra(3);
        }
    }
}
