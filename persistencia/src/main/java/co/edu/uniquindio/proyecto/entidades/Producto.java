package co.edu.uniquindio.proyecto.entidades;

import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="nombre",nullable = false)
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="precio_venta")
    private String precioVenta;

    @Column(name="precio_compra")
    private String precioCompra;

    @Column(name="unidades_disponibles")
    private String unidadesDisponibles;

    @OneToMany( mappedBy = "productoInventario")
    private List<Inventario> inventarios;

    @OneToMany( mappedBy = "productoDetalle")
    private List<DetalleCompra> detalleCompras;

    @ManyToOne
    private TipoProducto tipoProducto;

    @OneToMany( mappedBy = "productoPedido")
    private List<DetallePedido> pedidos;
}
