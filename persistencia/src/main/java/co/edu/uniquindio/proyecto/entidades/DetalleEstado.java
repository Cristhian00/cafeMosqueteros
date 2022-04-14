package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(LlaveDetalleEstado.class)
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetalleEstado implements Serializable {

    @Column(name = "fecha")
    private Date fecha;

    @Id
    @ManyToOne
    @EqualsAndHashCode.Include
    private EstadoCompra estadoDetalle;

    @Id
    @ManyToOne
    @EqualsAndHashCode.Include
    private Compra compraEstado;

    public DetalleEstado(Date fecha, EstadoCompra estadoDetalle, Compra compraEstado) {
        this.fecha = fecha;
        this.estadoDetalle = estadoDetalle;
        this.compraEstado = compraEstado;
    }
}
