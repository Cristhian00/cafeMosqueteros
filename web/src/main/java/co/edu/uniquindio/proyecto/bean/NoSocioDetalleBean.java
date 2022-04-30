package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.NoSocio;
import co.edu.uniquindio.proyecto.servicios.NoSocioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class NoSocioDetalleBean implements Serializable {

    @Autowired
    private NoSocioServicio noSocioServicio;

    @Getter
    @Setter
    private NoSocio noSocio;

    @Value("#{param['usuario']}")
    private String cedula;

    @PostConstruct
    public void init() throws Exception {
        if (cedula != null && !"".equals(cedula)) {
            this.noSocio = noSocioServicio.obtenerNoSocio(cedula);
        }
    }

    public void actualizarNoSocio(){
        FacesMessage msg;
        try {
            noSocioServicio.actualizarNoSocio(noSocio);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Alerta", "Se actualizo con exito");
            FacesContext.getCurrentInstance().addMessage("mensaje-noSocio", msg);
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje-noSocio", msg);
        }
    }
}
