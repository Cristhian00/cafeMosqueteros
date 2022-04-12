package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
@IdClass(LlaveDetallePedido.class)
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetallePedido implements Serializable {

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_unitario")
    private double precioUnitario;

    @Id
    @ManyToOne
    @EqualsAndHashCode.Include
    private Producto productoPedido;

    @Id
    @ManyToOne
    @EqualsAndHashCode.Include
    private Pedido pedidoDetalle;

    public DetallePedido(@Positive int cantidad,@Positive double precioUnitario,
                         Producto productoPedido, Pedido pedidoDetalle) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.productoPedido = productoPedido;
        this.pedidoDetalle = pedidoDetalle;
    }
}
