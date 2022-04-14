package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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

    public Compra(Date fecha, @Positive double total, Socio socioCompra) {
        this.fecha = fecha;
        this.total = total;
        this.socioCompra = socioCompra;
        this.detalleCompras = new ArrayList<>();
        this.estados = new ArrayList<>();
    }
}
