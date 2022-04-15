package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Nivel;
import co.edu.uniquindio.proyecto.repositorios.NivelRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NivelServicioImp implements NivelServicio{

    private final NivelRepo nivelRepo;

    public NivelServicioImp(NivelRepo nivelRepo) {  this.nivelRepo = nivelRepo; }

    @Override
    public Nivel registrarNivel(Nivel n) throws Exception {
        return null;
    }

    @Override
    public Nivel actualizarNivel(Nivel n) throws Exception {
        return null;
    }

    @Override
    public void eliminarNivel(int numeroNivel) throws Exception {

    }

    @Override
    public List<Nivel> listarNivel() {
        return null;
    }
}
