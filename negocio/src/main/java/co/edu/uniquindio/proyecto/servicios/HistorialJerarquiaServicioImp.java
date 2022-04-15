package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.HistorialJerarquia;
import co.edu.uniquindio.proyecto.repositorios.HistorialJerarquiaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialJerarquiaServicioImp implements  HistorialJerarquiaServicio{

    private final HistorialJerarquiaRepo historialJerarquiaRepo;

    public HistorialJerarquiaServicioImp(HistorialJerarquiaRepo historialJerarquiaRepo) {
        this.historialJerarquiaRepo = historialJerarquiaRepo;
    }

    @Override
    public HistorialJerarquia registrarHistorialJerarquia(HistorialJerarquia historialJerarquia) throws Exception {
        return null;
    }

    @Override
    public HistorialJerarquia actualizarHistorialJerarquia(HistorialJerarquia historialJerarquia) throws Exception {
        return null;
    }

    @Override
    public void eliminarHistorialJerarquia(int idJerarquia) throws Exception {

    }

    @Override
    public List<HistorialJerarquia> listarHistorialJerarquia() {
        return null;
    }
}
