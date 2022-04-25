package co.edu.uniquindio.proyecto.converter;

import co.edu.uniquindio.proyecto.entidades.TipoProducto;
import co.edu.uniquindio.proyecto.servicios.TipoProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import java.io.Serializable;

@Component
public class TipoProductoConverter implements Converter<TipoProducto>, Serializable {

    @Autowired
    private TipoProductoServicio tipoProductoServicio;

    @Override
    public TipoProducto getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        try {
            if (s != null && !"".equals(s)) {
                int id = Integer.parseInt(s);
                return tipoProductoServicio.obtenerTipo(id);
            }
        } catch (Exception e) {
            throw new ConverterException(new FacesMessage(uiComponent.getId() + ": id no valida"));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, TipoProducto tipo) {
        if (tipo != null) {
            return "" + tipo.getIdTipo();
        }
        return "";
    }
}
