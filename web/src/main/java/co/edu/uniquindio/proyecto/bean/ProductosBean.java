package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

@Component
@RequestScope
public class ProductosBean implements Serializable {

    @Autowired
    private ProductoServicio productoServicio;

    @Getter
    @Setter
    private List<Producto> productos;

    @PostConstruct
    public void inicializar(){
        this.productos = productoServicio.listarProductosActivos();
    }

    public String actualizarEliminar(int idProducto) {
        return "/administrador/producto.xhtml?faces-redirect=true&amp;producto=" + idProducto;
    }

    public String registrar(){
        return "/administrador/registrarProducto.xhtml?faces-redirect=true";
    }
}
