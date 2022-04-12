package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedido")
    @EqualsAndHashCode.Include
    private int idPedido;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name="total")
    private double total;

    @ManyToOne
    private Distribuidor distribuidorPedido;

    @OneToMany( mappedBy = "pedidoDetalle")
    private List<DetallePedido> pedidos;

    public Pedido(Date fecha, @Positive double total, Distribuidor distribuidorPedido) {
        this.fecha = fecha;
        this.total = total;
        this.distribuidorPedido = distribuidorPedido;
        this.pedidos = new ArrayList<>();
    }
}
