package co.edu.uniquindio.proyecto.servicios;



import co.edu.uniquindio.proyecto.entidades.Producto;

import java.util.List;

public interface ProductoServicio {
    Producto registrarProducto(Producto producto) throws Exception;

    Producto actualizarProducto(Producto producto) throws Exception;

    void eliminarProducto(int idProducto) throws Exception;

    List<Producto> listarProducto();
}
