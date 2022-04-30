package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.TipoProducto;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.TipoProductoServicio;
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
public class productoDetalleBean implements Serializable {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private TipoProductoServicio tipoProductoServicio;

    @Getter
    @Setter
    private Producto producto;

    @Value("#{param['producto']}")
    private String idProducto;

    @Getter
    @Setter
    private List<TipoProducto> tipos;

    @PostConstruct
    public void init() throws Exception {
        this.tipos = tipoProductoServicio.listarTipoProducto();
        if (idProducto != null && !"".equals(idProducto)) {
            int id = Integer.parseInt(idProducto);
            this.producto = productoServicio.obtenerProducto(id);
        }
    }

    public void actualizarProducto(){
        FacesMessage msg;
        try {
            productoServicio.actualizarProducto(producto);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Alerta", "Se actualizo con exito");
            FacesContext.getCurrentInstance().addMessage("mensaje-producto", msg);
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje-producto", msg);
        }
    }

    public String eliminarProducto(){
        FacesMessage msg;
        try {
            productoServicio.eliminarProducto(producto.getIdProducto());
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Alerta", "Se elimino con exito");
            FacesContext.getCurrentInstance().addMessage("mensaje-producto", msg);
            return "/administrador/productos.xhtml?faces-redirect=true";
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje-producto", msg);
        }
        return "";
    }
}
