package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@RequestScope
public class ProductoRegBean implements Serializable {

    private final ProductoServicio productoServicio;
    private Producto producto;


    public ProductoRegBean(ProductoServicio productoServicio) {this.productoServicio = productoServicio;  }

    public void inicializar (){this.producto = new Producto();}

    public String registrarProducto() {

        FacesMessage msg;
        try {
            productoServicio.registrarProducto(producto);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Alerta", "El registro fue exitoso");
            FacesContext.getCurrentInstance().addMessage("mensaje-usuario", msg);
            return "/Producto/registrarProducto.xhtml?faces-redirect=true";
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje-usuario", msg);
        }
        return "";
    }
}
