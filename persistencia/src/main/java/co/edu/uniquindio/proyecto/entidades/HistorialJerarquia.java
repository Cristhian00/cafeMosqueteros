package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class HistorialJerarquia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="fecha_inicio")
    private Date fechaInicio;
    @Column(name= "fecha_fin")
    private Date fechaFin;
}
