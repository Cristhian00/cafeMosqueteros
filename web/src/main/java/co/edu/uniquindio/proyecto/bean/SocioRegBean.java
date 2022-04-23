package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Socio;
import co.edu.uniquindio.proyecto.servicios.SocioServicio;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@RequestScope
public class SocioRegBean implements Serializable {

    private final SocioServicio socioServicio;
    private Socio socio;


    public SocioRegBean(SocioServicio socioServicio) {
        this.socioServicio = socioServicio;
    }

    public void inicializar (){
        this.socio = new Socio();
    }

    public String registrarSocio() {

        FacesMessage msg;
        try {
            socioServicio.registrarSocio(socio);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Alerta", "El registro fue exitoso");
            FacesContext.getCurrentInstance().addMessage("mensaje-usuario", msg);
            return "/index.xhtml?faces-redirect=true";
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje-usuario", msg);
        }
        return "";
    }
}
