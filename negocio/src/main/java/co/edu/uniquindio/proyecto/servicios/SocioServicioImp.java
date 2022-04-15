package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Socio;
import co.edu.uniquindio.proyecto.repositorios.SocioRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocioServicioImp implements SocioServicio{

    private final SocioRepo socioRepo;

    public SocioServicioImp(SocioRepo socioRepo) {
        this.socioRepo = socioRepo;
    }

    @Override
    public Socio registrarSocio(Socio s) throws Exception {
        return null;
    }

    @Override
    public Socio actualizarSocio(Socio s) throws Exception {
        return null;
    }

    @Override
    public void eliminarSocio(String cedula) throws Exception {

    }

    @Override
    public List<Socio> listarSocio() {
        return null;
    }
}
