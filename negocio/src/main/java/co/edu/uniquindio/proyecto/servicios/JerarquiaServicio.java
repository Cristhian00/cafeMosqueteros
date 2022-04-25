package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.Jerarquia;

import java.util.List;

public interface JerarquiaServicio {

    Jerarquia registrarJerarquia(Jerarquia j) throws Exception;

    Jerarquia actualizarJerarquia(Jerarquia j) throws Exception;

    void eliminarJerarquia(int idJerarquia) throws Exception;

    Jerarquia obtenerJerarquia(String nombre);

    Jerarquia obtenerJerarquia(int id);

    List<Jerarquia> listarJerarquia();
}
