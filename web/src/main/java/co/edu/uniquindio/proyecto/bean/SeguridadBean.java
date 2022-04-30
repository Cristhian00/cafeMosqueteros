package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.servicios.AdministradorServicioImp;
import co.edu.uniquindio.proyecto.servicios.PersonaServicioImp;
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
    private PersonaServicioImp personaServicio;

    @Autowired
    private AdministradorServicioImp adm;

    @Getter
    @Setter
    private Persona persona;

    @Getter
    @Setter
    private Administrador administrador;

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
                administrador = adm.login(correo, contrasenia);
                if(administrador == null){
                    persona = personaServicio.login(correo, contrasenia);
                    if(persona instanceof Socio){
                        rol = "socio";
                    } else if(persona instanceof NoSocio){
                        rol = "noSocio";
                    }
                } else {
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

    public String registrarNoSocio(){
        return "/registrarNoSocio.xhtml?faces-redirect=true";
    }
}
