package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.NoSocio;
import co.edu.uniquindio.proyecto.repositorios.NoSocioRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoSocioServicioImp implements NoSocioServicio{

    private final NoSocioRepo noSocioRepo;

    public NoSocioServicioImp(NoSocioRepo noSocioRepo) {
        this.noSocioRepo = noSocioRepo;
    }


    @Override
    public NoSocio registrarNoSocio(NoSocio noSocio) throws Exception {
        return null;
    }

    @Override
    public NoSocio actualizarNoSocio(NoSocio noSocio) throws Exception {
        return null;
    }

    @Override
    public void eliminarNoSocio(String cedula) throws Exception {

    }

    @Override
    public List<NoSocio> listarNoSocio() {
        return null;
    }
}
