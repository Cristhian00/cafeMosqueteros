package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(LlaveInventario.class)
public class Inventario implements Serializable {

    @Column(name = "cantidad")
    private int cantidad;

    @Id
    @ManyToOne
    private Socio socioInventario;

    @Id
    @ManyToOne
    private Producto productoInventario;
}
