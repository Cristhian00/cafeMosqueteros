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
    private  final SocioRepo socioRepo;
   // private  final PromocionRepo promocionRepo;

    public JerarquiaServicioImp(JerarquiaRepo jerarquiaRepo, SocioRepo socioRepo) {
        this.jerarquiaRepo = jerarquiaRepo;
        this.socioRepo = socioRepo;
      //  this.promocionRepo = promocionRepo;
    }

    public boolean  existeSocio(String cedula) {
        Optional<Socio> socio = socioRepo.findById(cedula);
        return socio.isEmpty();
    }
    public EstadoSocio estadoSocio(String cedula) {
        Socio socio = socioRepo.obtenerUsuarioCedula(cedula);
        if (socio.getEstado() == EstadoSocio.ACTIVO) {
            return EstadoSocio.ACTIVO;
        } else if (socio.getEstado() == EstadoSocio.PENDIENTE) {
            return EstadoSocio.PENDIENTE;
        } else {
            return EstadoSocio.NO_ACTIVO;
        }
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
