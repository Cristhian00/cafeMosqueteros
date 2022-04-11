package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Promocion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "decuento")
    private double descuento;

    @OneToMany(mappedBy = "promocionJerarquia")
    private List<Jerarquia> jerarquias;
}
