package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class TipoProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="unidad_medida")
    private String unidadMedida;
    @Column(name="medida")
    private double medida;
}
