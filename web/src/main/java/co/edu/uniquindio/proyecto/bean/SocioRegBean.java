package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Socio;
import co.edu.uniquindio.proyecto.servicios.SocioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@RequestScope
public class SocioRegBean implements Serializable {

    private final SocioServicio socioServicio;

    @Getter
    @Setter
    private String contrasenia;

    @Getter
    @Setter
    private Socio socio;

    @Getter
    @Setter
    private String cedulaPadre;

    public SocioRegBean(SocioServicio socioServicio) {
        this.socioServicio = socioServicio;
    }

    @PostConstruct
    public void inicializar() {
        this.socio = new Socio();
    }

    public String registrarSocio() throws Exception {

        FacesMessage msg;
        if (cedulaPadre != null) {
            Socio padre = socioServicio.obtenerSocio(cedulaPadre);
            if (padre != null) {
                try {
                    if(contrasenia!=null && contrasenia!=socio.getContrasenia()){
                        throw new Exception("Las contraseñas no coinciden");
                    }
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
            }
        }
        return null;
    }
}
