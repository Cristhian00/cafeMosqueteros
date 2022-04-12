package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
@IdClass(LlaveGanancia.class)
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ganancia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGanancias")
    @EqualsAndHashCode.Include
    private int idGanancias;

    @Column(name = "ganancias")
    private double ganancias;

    @Column(name = "anio")
    private int anio;

    @Column(name = "mes")
    private String mes;

    @Id
    @ManyToOne
    @EqualsAndHashCode.Include
    private Socio socioGanancia;

    public Ganancia(@Positive double ganancias,@Positive int anio, String mes, Socio socioGanancia) {
        this.ganancias = ganancias;
        this.anio = anio;
        this.mes = mes;
        this.socioGanancia = socioGanancia;
    }
}
