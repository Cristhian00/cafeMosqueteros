package co.edu.uniquindio.proyecto.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
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

    public Socio(String cedula, String primerNombre, String primerApellido, String correo,
                 String celular, String contrasenia, Date fechaVinculacion, String estado,
                 Socio padre, Jerarquia jerarquia) {
        super(cedula, primerNombre, primerApellido, correo, celular, contrasenia);
        this.fechaVinculacion = fechaVinculacion;
        this.estado = estado;
        this.padre = padre;
        this.hijos = new ArrayList<>();
        this.jerarquia = jerarquia;
        this.inventarios = new ArrayList<>();
        this.historiales = new ArrayList<>();
        this.ganancias = new ArrayList<>();
        this.compras = new ArrayList<>();
    }
}
