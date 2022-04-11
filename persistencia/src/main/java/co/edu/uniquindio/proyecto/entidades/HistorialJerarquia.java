package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@IdClass(LlaveHistorial.class)
public class HistorialJerarquia implements Serializable {

    @Column(name="fecha_inicio")
    private Date fechaInicio;

    @Column(name= "fecha_fin")
    private Date fechaFin;

    @Id
    @ManyToOne
    private Socio socioHistorial;

    @Id
    @ManyToOne
    private Jerarquia jerarquiahistorial;
}
