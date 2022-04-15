package co.edu.uniquindio.proyecto.servicios;



import co.edu.uniquindio.proyecto.entidades.HistorialJerarquia;

import java.util.List;

public interface HistorialJerarquiaServicio {
    HistorialJerarquia registrarHistorialJerarquia(HistorialJerarquia historialJerarquia) throws Exception;

    HistorialJerarquia actualizarHistorialJerarquia(HistorialJerarquia historialJerarquia) throws Exception;

    void eliminarHistorialJerarquia(int idJerarquia) throws Exception;

    List<HistorialJerarquia> listarHistorialJerarquia();
}
