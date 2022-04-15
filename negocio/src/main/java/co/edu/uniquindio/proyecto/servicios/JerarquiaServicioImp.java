package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Jerarquia;
import co.edu.uniquindio.proyecto.repositorios.JerarquiaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JerarquiaServicioImp implements JerarquiaServicio{

    private final JerarquiaRepo jerarquiaRepo;

    public JerarquiaServicioImp(JerarquiaRepo jerarquiaRepo) {
        this.jerarquiaRepo = jerarquiaRepo;
    }


    @Override
    public Jerarquia registrarJerarquia(Jerarquia j) throws Exception {
        return null;
    }

    @Override
    public Jerarquia actualizarJerarquia(Jerarquia j) throws Exception {
        return null;
    }

    @Override
    public void eliminarJerarquia(int idJerarquia) throws Exception {

    }

    @Override
    public List<Jerarquia> listarJerarquia() {
        return null;
    }
}
