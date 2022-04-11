package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Ganancias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ganancias")
    private double ganancias;
    @Column(name="anio")
    private int anio;
    @Column(name = "mes")
    private String mes;
}
