package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EstadoCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstado")
    @EqualsAndHashCode.Include
    private int idEstado;

    @Column(name = "descripcion", length = 100, unique = true)
    private String descripcion;

    @OneToMany(mappedBy = "estadoDetalle")
    private List<DetalleEstado> estados;

    public EstadoCompra(String descripcion) {
        this.descripcion = descripcion;
        this.estados = new ArrayList<>();
    }
}
