package co.edu.uniquindio.proyecto.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Socio extends Persona implements Serializable {

    @Column(name = "fecha")
    private Date fechaVinculacion;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    private Socio padre;

    @OneToMany(mappedBy = "padre")
    private List<Socio> hijos;

    @ManyToOne
    private Jerarquia jerarquia;

    @OneToMany(mappedBy = "socioInventario")
    private List<Inventario> inventarios;

    @OneToMany(mappedBy = "socioHistorial")
    private List<HistorialJerarquia> historiales;

    @OneToMany(mappedBy = "socioGanancia")
    private List<Ganancia> ganancias;

    @OneToMany(mappedBy = "socioCompra")
    private List<Compra> compras;
}
