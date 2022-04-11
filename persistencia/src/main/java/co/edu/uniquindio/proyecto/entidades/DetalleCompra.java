package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(LlaveDetalleCompra.class)
public class DetalleCompra implements Serializable {

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_unitario")
    private double precioUnitario;

    @Id
    @ManyToOne
    private Producto productoDetalle;

    @Id
    @ManyToOne
    private Compra compraDetalle;
}
