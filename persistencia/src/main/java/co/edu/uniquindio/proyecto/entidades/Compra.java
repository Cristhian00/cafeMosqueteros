package co.edu.uniquindio.proyecto.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "total", nullable = false)
    private double total;

    @ManyToOne
    private Socio socioCompra;

    @ManyToOne
    private NoSocio noSocioCompra;

    @JsonIgnore
    @OneToMany(mappedBy = "compraDetalle")
    private List<DetalleCompra> detalleCompras;

    private EstadoCompra estado;

    public Compra(Socio socioCompra, NoSocio noSocioCompra, EstadoCompra estado) {
        this.socioCompra = socioCompra;
        this.noSocioCompra = noSocioCompra;
        this.detalleCompras = new ArrayList<>();
        this.estado = estado;
    }

    @Override
    public String toString() {
        if (socioCompra != null) {
            return "Compra{" +
                    "ID Compra=" + idCompra +
                    ", fecha=" + fecha +
                    ", total=" + total +
                    ", socioCompra=" + socioCompra.getCedula() +
                    ", estadoCompra=" + estado.name() +
                    '}';
        } else if (noSocioCompra != null) {
            return "Compra{" +
                    "idCompra=" + idCompra +
                    ", fecha=" + fecha +
                    ", total=" + total +
                    ", noSocioCompra=" + noSocioCompra.getCedula() +
                    ", estadoCompra=" + estado.name() +
                    '}';
        }
        return null;
    }
}
