package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class EstadoCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="descripcion", length = 100)
    private String descripcion;

    @OneToMany( mappedBy = "estadoDetalle")
    private List<DetalleEstado> estados;
}
