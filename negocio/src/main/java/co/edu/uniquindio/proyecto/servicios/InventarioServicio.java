package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.Inventario;

import java.util.List;

public interface InventarioServicio {
    Inventario registrarInventario(Inventario i) throws Exception;

    Inventario actualizarInventario(Inventario i) throws Exception;

    void eliminarInventario(String cedulaSocio) throws Exception;

    List<Inventario> listarInventario();
}
