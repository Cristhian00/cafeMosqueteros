package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedido")
    private int idPedido;

    @Column(name ="fecha")
    private Date fecha;

    @Column(name="total")
    private double total;

    @ManyToOne
    private Distribuidor distribuidorPedido;

    @OneToMany( mappedBy = "pedidoDetalle")
    private List<DetallePedido> pedidos;
}
