package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.TipoProducto;

import java.util.List;
import java.util.Optional;

public interface TipoProductoServicio {

    TipoProducto registrarTipoProducto(TipoProducto tipoProducto) throws Exception;

    TipoProducto actualizarTipoProducto(TipoProducto tipoProducto) throws Exception;

    void eliminarTipoProducto(int idTipo) throws Exception;

    List<TipoProducto> listarTipoProducto();

    TipoProducto obtenerTipo(int id) throws Exception;
}
