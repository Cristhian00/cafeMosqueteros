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
public class Promocion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPromocion")
    @EqualsAndHashCode.Include
    private int idPromocion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "decuento")
    private double descuento;

    @OneToMany(mappedBy = "promocionJerarquia")
    private List<Jerarquia> jerarquias;
}
