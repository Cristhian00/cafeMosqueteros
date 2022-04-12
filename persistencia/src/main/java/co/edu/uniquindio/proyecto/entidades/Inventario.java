package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
@IdClass(LlaveInventario.class)
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Inventario implements Serializable {

    @Column(name = "cantidad")
    private int cantidad;

    @Id
    @ManyToOne
    @EqualsAndHashCode.Include
    private Socio socioInventario;

    @Id
    @ManyToOne
    @EqualsAndHashCode.Include
    private Producto productoInventario;

    public Inventario(@Positive int cantidad, Socio socioInventario, Producto productoInventario) {
        this.cantidad = cantidad;
        this.socioInventario = socioInventario;
        this.productoInventario = productoInventario;
    }
}
