package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(LlaveHistorial.class)
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HistorialJerarquia implements Serializable {

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Id
    @ManyToOne
    @EqualsAndHashCode.Include
    private Socio socioHistorial;

    @Id
    @ManyToOne
    @EqualsAndHashCode.Include
    private Jerarquia jerarquiahistorial;

    public HistorialJerarquia(Date fechaInicio, Date fechaFin, Socio socioHistorial, Jerarquia jerarquiahistorial) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.socioHistorial = socioHistorial;
        this.jerarquiahistorial = jerarquiahistorial;
    }
}
