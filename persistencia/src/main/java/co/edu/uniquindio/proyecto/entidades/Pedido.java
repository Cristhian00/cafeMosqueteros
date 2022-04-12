package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
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
}
