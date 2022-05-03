package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.servicios.EmailServicio;
import co.edu.uniquindio.proyecto.servicios.PersonaServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@RequestScope
public class EmailBean implements Serializable {

    @Autowired
    private EmailServicio emailServicio;

    @Autowired
    private PersonaServicio personaServicio;

    @Getter
    @Setter
    private Persona persona;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String cedula;

    @Getter
    @Setter
    private String asunto;

    @Getter
    @Setter
    private String mensaje;

    public String enviarCorreo() {

        if (cedula != null && email != null) {
            try {
                persona = personaServicio.recuperarContrasenia(cedula, email);
                asunto = "Recuperar contraseña";

                mensaje = "Hola, " + persona.getPrimerNombre() + "\nEstos son sus datos de login para acceder a Café Mosqueteros. " +
                        "No comparta esta información con ningún tercero.\n\n"
                        + "Email: " + email + "\nContraseña: " + persona.getContrasenia() + "\n\nHasta luego.";

                emailServicio.SendSimpleMessage(email, asunto, mensaje);
                return "/index.xhtml?faces-redirect=true";
            } catch (Exception e) {
                FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje-recuperar", m);
            }
        }
        return null;
    }
}
