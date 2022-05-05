package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.servicios.AdministradorServicioImp;
import co.edu.uniquindio.proyecto.servicios.PersonaServicioImp;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;

@Component
@Scope("session")
public class SeguridadBean implements Serializable {

    @Autowired
    private PersonaServicioImp personaServicio;

    @Autowired
    private AdministradorServicioImp adm;

    @Getter
    @Setter
    private ArrayList<Producto> carrito;

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

    @PostConstruct
    public void inicializar() {
        carrito = new ArrayList<>();
    }

    public boolean esActivo(int numero) {
        String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId().replace(".xhtml", "");
        if (numero == 1 && viewId.equals("/index")) {
            return true;
        } else if (numero == 2 && viewId.equals("/productos")) {
            return true;
        } else if (numero == 3 && viewId.equals("/casosDeExito")) {
            return true;
        } else if (numero == 4 && viewId.equals("/registrarNoSocio")) {
            return true;
        } else if (numero == 5 && viewId.equals("/sobreNosotros")) {
            return true;
        } else if (numero == 6 && viewId.equals("/trabajaConNosotros")) {
            return true;
        } else if (numero == 7 && viewId.equals("/administrador/productos")) {
            return true;
        } else if (numero == 8 && viewId.equals("/administrador/socios")) {
            return true;
        } else if (numero == 9 && viewId.equals("/administrador/ventas")) {
            return true;
        } else if (numero == 10 && viewId.equals("/noSocio/perfilNoSocio")) {
            return true;
        } else if (numero == 11 && viewId.equals("/socio/perfilSocio")) {
            return true;
        }
        return false;
    }

    public void agregarAlCarrito(Producto producto) {
        carrito.add(producto);
        System.out.println(carrito);
    }

    public String iniciarSesion() {

        if (correo != null && contrasenia != null) {
            try {
                administrador = adm.login(correo, contrasenia);
                if (administrador == null) {
                    persona = personaServicio.login(correo, contrasenia);
                    if (persona instanceof Socio) {
                        rol = "socio";
                    } else if (persona instanceof NoSocio) {
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

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }

    public String recuperar() {
        return "/recuperarContrasenia.xhtml?faces-redirect=true";
    }

    public String registrarNoSocio() {
        return "/registrarNoSocio.xhtml?faces-redirect=true";
    }
}
