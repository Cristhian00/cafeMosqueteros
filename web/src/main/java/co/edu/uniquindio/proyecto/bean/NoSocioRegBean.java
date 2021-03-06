package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.NoSocio;
import co.edu.uniquindio.proyecto.entidades.Socio;
import co.edu.uniquindio.proyecto.servicios.NoSocioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.time.Clock;

@Component
@RequestScope
public class NoSocioRegBean implements Serializable {

    private final NoSocioServicio noSocioServicio;

    @Getter
    @Setter
    private NoSocio noSocio;

    @Getter
    @Setter
    private String contrasenia;

    public NoSocioRegBean(NoSocioServicio noSocioServicio) {
        this.noSocioServicio = noSocioServicio;
    }

    @PostConstruct
    public void inicializar() {
        this.noSocio = new NoSocio();
    }

    public String registrarNoSocio() throws Exception {

        FacesMessage msg;
        try {
            if (contrasenia != null && !contrasenia.equals(noSocio.getContrasenia())) {
                throw new Exception("Las contraseñas no coinciden");
            }
            noSocioServicio.registrarNoSocio(noSocio);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Alerta", "El registro fue exitoso");
            FacesContext.getCurrentInstance().addMessage("mensaje-noSocio", msg);
            return "/index.xhtml?faces-redirect=true";
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje-noSocio", msg);
        }
        return null;
    }
}
