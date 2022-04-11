package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Jerarquia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
