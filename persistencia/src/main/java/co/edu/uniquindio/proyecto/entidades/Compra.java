package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name= "fecha")
    private Date fecha;
    @Column(name = "total")
    private double total;

    public Compra() {
        super();
    }
}
