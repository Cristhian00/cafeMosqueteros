package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TipoProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipo")
    @EqualsAndHashCode.Include
    private int idTipo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "unidad_medida")
    private String unidadMedida;

    @Column(name = "medida")
    private double medida;

    @OneToMany(mappedBy = "tipoProducto")
    private List<Producto> productos;

    public TipoProducto(String descripcion, String unidadMedida, @Positive double medida) {
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.medida = medida;
        this.productos = new ArrayList<>();
    }
}
