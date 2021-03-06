package co.edu.uniquindio.proyecto.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Socio extends Persona implements Serializable {

    @Column(name = "fecha", nullable = false)
    private Date fechaVinculacion;

    //Estado en el que se encuentra el lugar
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoSocio estado;

    @ManyToOne
    private Socio padre;

    @JsonIgnore
    @OneToMany(mappedBy = "padre")
    private List<Socio> hijos;

    @ManyToOne
    private Jerarquia jerarquia;

    @JsonIgnore
    @OneToMany(mappedBy = "socioInventario")
    private List<Inventario> inventarios;

    @JsonIgnore
    @OneToMany(mappedBy = "socioHistorial")
    private List<HistorialJerarquia> historiales;

    @JsonIgnore
    @OneToMany(mappedBy = "socioGanancia")
    private List<Ganancia> ganancias;

    @JsonIgnore
    @OneToMany(mappedBy = "socioCompra")
    private List<Compra> compras;

    public Socio(String cedula, String primerNombre, String primerApellido, String correo,
                 String celular, String contrasenia, Date fechaVinculacion, EstadoSocio estado,
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

    @Override
    public String toString() {
        return "Socio{" +
                "fechaVinculacion=" + fechaVinculacion +
                ", estado=" + estado.name() +
                ", padre=" + padre.getCedula() +
                ", jerarquia=" + jerarquia.getNombre() +
                '}';
    }
}
