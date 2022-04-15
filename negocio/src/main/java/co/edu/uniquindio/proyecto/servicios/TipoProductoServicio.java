package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.TipoProducto;

import java.util.List;

public interface TipoProductoServicio {

    TipoProducto registrarTipoProducto(TipoProducto tipoProducto) throws Exception;

    TipoProducto actualizarTipoProducto(TipoProducto tipoProducto) throws Exception;

    void eliminarTipoProducto(int idTipo) throws Exception;

    List<TipoProducto> listarTipoProducto();
}
