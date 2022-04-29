package co.edu.uniquindio.proyecto.servicios;



import co.edu.uniquindio.proyecto.entidades.Producto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoServicio {
    Producto registrarProducto(Producto producto) throws Exception;

    Producto actualizarProducto(Producto producto) throws Exception;

    boolean eliminarProducto(int idProducto) throws Exception;

    @Query("SELECT p FROM Producto p WHERE p.idProducto = ?1")
    Producto obtenerProducto(int id) throws Exception;

    List<Producto> listarProducto();
}
