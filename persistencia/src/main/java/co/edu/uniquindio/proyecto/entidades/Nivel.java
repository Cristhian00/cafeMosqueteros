package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Nivel implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "numero_nivel")
    private int numeroNivel;

    @Column(name = "comision")
    private double comision;

    public Nivel(@Positive int numeroNivel,@Positive double comision) {
        this.numeroNivel = numeroNivel;
        this.comision = comision;
    }
}
