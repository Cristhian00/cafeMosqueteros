package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.TipoProducto;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.TipoProductoServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class ProductoRegBean implements Serializable {

    private final ProductoServicio productoServicio;
    private final TipoProductoServicio tipoProductoServicio;

    @Getter
    @Setter
    private Producto producto;

    @Getter
    @Setter
    private List<TipoProducto> tipos;

    public ProductoRegBean(ProductoServicio productoServicio, TipoProductoServicio tipoProductoServicio) {
        this.productoServicio = productoServicio;
        this.tipoProductoServicio = tipoProductoServicio;
    }

    @PostConstruct
    public void inicializar (){
        this.producto = new Producto();
        this.tipos = tipoProductoServicio.listarTipoProducto();
    }

    public String registrarProducto() {

        FacesMessage msg;
        try {
            productoServicio.registrarProducto(producto);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Alerta", "El registro fue exitoso");
            FacesContext.getCurrentInstance().addMessage("mensaje-socio", msg);
            return "/administrador/productos.xhtml?faces-redirect=true";
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje-socio", msg);
        }
        return null;
    }
}
