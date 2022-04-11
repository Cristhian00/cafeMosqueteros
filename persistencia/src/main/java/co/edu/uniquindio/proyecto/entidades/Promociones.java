package co.edu.uniquindio.proyecto.entidades;

import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Promociones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="decuento")
    private double descuento;
}
