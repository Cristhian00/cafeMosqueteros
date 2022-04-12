package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Jerarquia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "nombre")
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
}
