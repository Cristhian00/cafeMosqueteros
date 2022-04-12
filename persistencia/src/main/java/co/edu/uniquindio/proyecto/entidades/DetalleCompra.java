package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
@IdClass(LlaveDetalleCompra.class)
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetalleCompra implements Serializable {

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_unitario")
    private double precioUnitario;

    @Id
    @ManyToOne
    @EqualsAndHashCode.Include
    private Producto productoDetalle;

    @Id
    @ManyToOne
    @EqualsAndHashCode.Include
    private Compra compraDetalle;

    public DetalleCompra(@Positive int cantidad,@Positive double precioUnitario,
                         Producto productoDetalle, Compra compraDetalle) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.productoDetalle = productoDetalle;
        this.compraDetalle = compraDetalle;
    }
}
