package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Socio extends Persona implements Serializable {

    private String idPadre;

    private Date fechaVinculacion;

    private String estado;

}
