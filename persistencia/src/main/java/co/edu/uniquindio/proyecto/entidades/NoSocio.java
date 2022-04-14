package co.edu.uniquindio.proyecto.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class NoSocio extends Persona implements Serializable {


    public NoSocio(String cedula, String primerNombre, String primerApellido, String correo, String celular, String contrasenia) {
        super(cedula, primerNombre, primerApellido, correo, celular, contrasenia);

    }
}
