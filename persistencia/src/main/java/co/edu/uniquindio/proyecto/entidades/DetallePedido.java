package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(LlaveDetallePedido.class)
public class DetallePedido implements Serializable {

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_unitario")
    private double precioUnitario;

    @Id
    @ManyToOne
    private Producto productoPedido;

    @Id
    @ManyToOne
    private Pedido pedidoDetalle;
}
