package co.edu.uniquindio.proyecto.entidades;

import co.edu.uniquindio.proyecto.repositorios.PersonaServicioRepo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class PersonaServicio extends Persona implements Serializable {


    public PersonaServicio(String cedula, String primerNombre, String primerApellido, String correo, String celular, String contrasenia) {
        super(cedula, primerNombre, primerApellido, correo, celular, contrasenia);
    }

    public Persona login (String correo, String contrasenia){
        if(!this.getCorreo().equals(correo)){
            throw  new RuntimeException("El correo no existe");
        }
        if(!this.getContrasenia().equals(contrasenia)){
            throw  new RuntimeException("La contraseña no es la correcta");
        }
        return this;

    }
}
