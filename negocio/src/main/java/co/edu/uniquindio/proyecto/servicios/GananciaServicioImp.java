package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Ganancia;
import co.edu.uniquindio.proyecto.repositorios.GananciaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GananciaServicioImp implements GananciaServicio {
    private final GananciaRepo gananciaRepo;

    public GananciaServicioImp(GananciaRepo gananciaRepo) {this.gananciaRepo = gananciaRepo; }


    @Override
    public Ganancia registrarGanancia(Ganancia g) throws Exception {
        return null;
    }

    @Override
    public Ganancia actualizarGanancia(Ganancia g) throws Exception {
        return null;
    }

    @Override
    public void eliminarGanancia(String cedula) throws Exception {

    }

    @Override
    public List<Ganancia> listarGanancia() {
        return null;
    }
}
