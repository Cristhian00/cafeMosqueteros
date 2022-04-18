package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Jerarquia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJerarquia")
    @EqualsAndHashCode.Include
    private int idJerarquia;

    @Column(name = "nombre", unique = true)
    private String nombre;

    @Column(name = "cantidad_hijos")
    private int cantidadHijos;

    @Column(name = "totalcentas")
    private int totalventas;

    @OneToMany(mappedBy = "jerarquia")
    private List<Socio> socios;

    @OneToMany(mappedBy = "jerarquiahistorial")
    private List<HistorialJerarquia> historiales;

    @ManyToOne
    private Promocion promocionJerarquia;

    public Jerarquia(String nombre, @Positive int cantidadHijos, @Positive int totalventas,
                     Promocion promocionJerarquia) {
        this.nombre = nombre;
        this.cantidadHijos = cantidadHijos;
        this.totalventas = totalventas;
        this.socios = new ArrayList<>();
        this.historiales = new ArrayList<>();
        this.promocionJerarquia = promocionJerarquia;
    }
}
