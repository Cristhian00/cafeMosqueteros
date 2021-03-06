package co.edu.uniquindio.proyecto.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class NoSocio extends Persona implements Serializable {

    @Column(name = "fecha", nullable = false)
    private Date fechaVinculacion;

    @JsonIgnore
    @OneToMany(mappedBy = "noSocioCompra")
    private List<Compra> compras;

    public NoSocio(String cedula, String primerNombre, String primerApellido, String correo, String celular, String contrasenia) {
        super(cedula, primerNombre, primerApellido, correo, celular, contrasenia);
    }

    @Override
    public String toString() {
        return "NoSocio{" +
                "fechaVinculacion=" + fechaVinculacion +
                '}';
    }
}
