package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCompra")
    @EqualsAndHashCode.Include
    private int idCompra;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "total")
    private double total;

    @ManyToOne
    private Socio socioCompra;

    @OneToMany(mappedBy = "compraDetalle")
    private List<DetalleCompra> detalleCompras;

    @OneToMany(mappedBy = "compraEstado")
    private List<DetalleEstado> estados;

}
