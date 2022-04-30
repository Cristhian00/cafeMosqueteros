package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Inventario;
import co.edu.uniquindio.proyecto.entidades.Socio;
import co.edu.uniquindio.proyecto.servicios.CompraServicio;
import co.edu.uniquindio.proyecto.servicios.InventarioServicio;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.SocioServicio;
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
import java.util.List;

@Component
@ViewScoped
public class SocioDetalleBean implements Serializable {

    @Autowired
    private SocioServicio socioServicio;

    @Autowired
    private InventarioServicio inventarioServicio;

    @Autowired
    private CompraServicio compraServicio;

    @Autowired
    private ProductoServicio productoServicio;

    @Value("#{param['socio']}")
    private String cedula;

    @Getter
    @Setter
    private Socio socio;

    @Getter
    @Setter
    private List<Inventario> inventarios;

    @Getter
    @Setter
    private List<Compra> compras;

    @PostConstruct
    public void init() throws Exception {
        if (cedula != null && !"".equals(cedula)) {
            this.socio = socioServicio.obtenerSocio(cedula);
            this.inventarios = inventarioServicio.listarInventarioSocio(socio.getCedula());
        }
    }

    public void actualizarSocio(){
        FacesMessage msg;
        try {
            socioServicio.actualizarSocio(socio);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Alerta", "Se actualizo con exito");
            FacesContext.getCurrentInstance().addMessage("mensaje-socio", msg);
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje-socio", msg);
        }
    }

    public String cancelarMembresia(){
        FacesMessage msg;
        try {
            socioServicio.eliminarSocio(socio.getCedula());
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Alerta", "Se elimino con exito");
            FacesContext.getCurrentInstance().addMessage("mensaje-socio", msg);
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            return "/index.xhtml?faces-redirect=true";
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje-socio", msg);
        }
        return "";
    }
}
