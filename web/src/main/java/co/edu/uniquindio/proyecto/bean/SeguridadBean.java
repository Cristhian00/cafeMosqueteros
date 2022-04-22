package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.NoSocio;
import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.entidades.Socio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@Scope("session")
public class SeguridadBean implements Serializable {

    @Autowired
    private PersonaServicio personaServicio;

    @Getter
    @Setter
    private Persona persona;

    @Getter
    @Setter
    private boolean autenticado;

    @Getter
    @Setter
    private String correo;

    @Getter
    @Setter
    private String contrasenia;

    @Getter
    @Setter
    private String rol;

    public String iniciarSesion() {

        if (correo != null && contrasenia != null) {
            try {
                persona = personaServicio.login(correo, contrasenia);
                if(persona instanceof Socio){
                    rol = "socio";
                } else if(persona instanceof NoSocio){
                    rol = "noSocio";
                } else{
                    rol = "administrador";
                }
                autenticado = true;
                return "/index.xhtml?faces-redirect=true";
            } catch (Exception e) {
                FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje-sesion", m);
            }
        }
        return null;
    }

    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }

    public String recuperar(){
        return "/recuperarContrasenia.xhtml?faces-redirect=true";
    }
}
