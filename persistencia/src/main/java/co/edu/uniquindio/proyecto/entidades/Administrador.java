package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrador implements Serializable {

    @Id
    @Column(name = "correo", unique = true)
    @EqualsAndHashCode.Include
    private String correo;

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;
}
