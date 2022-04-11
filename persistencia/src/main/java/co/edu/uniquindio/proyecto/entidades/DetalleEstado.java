package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@IdClass(LlaveDetalleEstado.class)
public class DetalleEstado implements Serializable {

    @Column(name ="fecha")
    private Date fecha;

    @Id
    @ManyToOne
    private EstadoCompra estadoDetalle;

    @Id
    @ManyToOne
    private Compra compraEstado;
}
