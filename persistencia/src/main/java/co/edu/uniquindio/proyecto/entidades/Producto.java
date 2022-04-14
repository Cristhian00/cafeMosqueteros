package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    @EqualsAndHashCode.Include
    private int idProducto;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_venta")
    private double precioVenta;

    @Column(name = "precio_compra")
    private double precioCompra;

    @Column(name = "unidades_disponibles")
    private int unidadesDisponibles;

    @OneToMany(mappedBy = "productoInventario")
    private List<Inventario> inventarios;

    @OneToMany(mappedBy = "productoDetalle")
    private List<DetalleCompra> detalleCompras;

    @ManyToOne
    private TipoProducto tipoProducto;

    @OneToMany(mappedBy = "productoPedido")
    private List<DetallePedido> pedidos;

    public Producto(String nombre, String descripcion, double precioVenta, double precioCompra,
                    int unidadesDisponibles, TipoProducto tipoProducto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.unidadesDisponibles = unidadesDisponibles;
        this.inventarios = new ArrayList<>();
        this.detalleCompras = new ArrayList<>();
        this.tipoProducto = tipoProducto;
        this.pedidos = new ArrayList<>();
    }
}
