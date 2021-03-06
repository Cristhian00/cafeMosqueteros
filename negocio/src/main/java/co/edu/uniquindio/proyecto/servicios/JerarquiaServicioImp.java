package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.EstadoSocio;
import co.edu.uniquindio.proyecto.entidades.Jerarquia;
import co.edu.uniquindio.proyecto.entidades.Promocion;
import co.edu.uniquindio.proyecto.entidades.Socio;
import co.edu.uniquindio.proyecto.repositorios.JerarquiaRepo;
import co.edu.uniquindio.proyecto.repositorios.PromocionRepo;
import co.edu.uniquindio.proyecto.repositorios.SocioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JerarquiaServicioImp implements JerarquiaServicio {

    private final JerarquiaRepo jerarquiaRepo;

    public JerarquiaServicioImp(JerarquiaRepo jerarquiaRepo) throws Exception {
        this.jerarquiaRepo = jerarquiaRepo;
    }

    public boolean existeJerarquia(int idJerarquia) {
        Optional<Jerarquia> j = jerarquiaRepo.findById(idJerarquia);
        return j.isPresent();
    }

    public boolean existeNombreJerarquia(String nombre) {

        Optional<Jerarquia> j = jerarquiaRepo.findByNombre(nombre);
        return j.isPresent();
    }

    public void validaciones(Jerarquia jerarquia) throws Exception {
        if (existeNombreJerarquia(jerarquia.getNombre())) {
            throw new Exception("El nombre de la jerarquia ya existe");
        }
        if (jerarquia.getNombre().length() > 50) {
            throw new Exception("El nombre de la jerarquia excede los caracteres");
        }
        if (jerarquia.getTotalventas() < 0) {
            throw new Exception("Lo sentimos no deben de haber ventas negativas");
        }
    }

    @Override
    public Jerarquia registrarJerarquia(Jerarquia j) throws Exception {
        validaciones(j);
        Jerarquia jerarquia = jerarquiaRepo.save(j);

        return jerarquia;
    }

    @Override
    public Jerarquia actualizarJerarquia(Jerarquia j) throws Exception {
        validaciones(j);
        Jerarquia jerarquia = jerarquiaRepo.save(j);

        return jerarquia;
    }


    @Override
    public void eliminarJerarquia(int idJerarquia) throws Exception {
        Jerarquia j = jerarquiaRepo.findByIdJerarquia(idJerarquia);
        if (existeNombreJerarquia(j.getNombre())) {
            throw new Exception("El nombre de la jerarquia ya existe");
        }
        if (existeJerarquia(j.getIdJerarquia())) {
            throw new Exception("La jerarquia ya existe");
        }
        jerarquiaRepo.delete(j);

    }

    @Override
    public Jerarquia obtenerJerarquia(String nombre) {
        return jerarquiaRepo.obtenerJerarquia(nombre);
    }

    @Override
    public Jerarquia obtenerJerarquia(int id) {
        return jerarquiaRepo.findByIdJerarquia(id);
    }

    @Override
    public List<Jerarquia> listarJerarquia() {
        return jerarquiaRepo.findAll();
    }
}
