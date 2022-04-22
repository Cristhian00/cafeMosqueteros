package co.edu.uniquindio.proyecto.bean;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.io.Serializable;

@Component
@RequestScope
public class InicioBean implements Serializable {

    private String mensaje = "Mi primera página en JSF";
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
