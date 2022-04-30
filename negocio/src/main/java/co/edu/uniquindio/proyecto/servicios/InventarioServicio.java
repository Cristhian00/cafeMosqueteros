package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.Inventario;
import co.edu.uniquindio.proyecto.entidades.Producto;

import java.util.List;

public interface InventarioServicio {
    Inventario registrarInventario(Inventario i) throws Exception;

    Inventario actualizarInventario(Inventario i) throws Exception;

    boolean eliminarInventario(String cedula, Producto producto) throws Exception;

    List<Inventario> listarInventarioSocio(String cedula) throws Exception;

    List<Inventario> listarInventario();
}
