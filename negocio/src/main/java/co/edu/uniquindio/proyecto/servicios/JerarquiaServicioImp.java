package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.EstadoSocio;
import co.edu.uniquindio.proyecto.entidades.Jerarquia;
import co.edu.uniquindio.proyecto.entidades.Socio;
import co.edu.uniquindio.proyecto.repositorios.JerarquiaRepo;
import co.edu.uniquindio.proyecto.repositorios.PromocionRepo;
import co.edu.uniquindio.proyecto.repositorios.SocioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JerarquiaServicioImp implements JerarquiaServicio{

    private final JerarquiaRepo jerarquiaRepo;

    public JerarquiaServicioImp(JerarquiaRepo jerarquiaRepo, SocioRepo socioRepo) {
        this.jerarquiaRepo = jerarquiaRepo;
    }

    @Override
    public Jerarquia registrarJerarquia(Jerarquia j) throws Exception {
        List<Socio> listaSocios = j.getSocios();

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
