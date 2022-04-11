package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(LlaveGanancia.class)
public class Ganancia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGanancias")
    private int idGanancias;

    @Column(name = "ganancias")
    private double ganancias;

    @Column(name = "anio")
    private int anio;

    @Column(name = "mes")
    private String mes;

    @Id
    @ManyToOne
    private Socio socioGanancia;
}
