package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.EstadoSocio;
import co.edu.uniquindio.proyecto.entidades.Ganancia;
import co.edu.uniquindio.proyecto.entidades.Socio;
import co.edu.uniquindio.proyecto.repositorios.GananciaRepo;
import co.edu.uniquindio.proyecto.repositorios.SocioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GananciaServicioImp implements GananciaServicio {
    private final GananciaRepo gananciaRepo;
    private final SocioRepo socioRepo;

    public GananciaServicioImp(GananciaRepo gananciaRepo, SocioRepo socioRepo) {
        this.gananciaRepo = gananciaRepo;
        this.socioRepo = socioRepo;
    }

    public boolean gananciaSocio(String cedula){
        Optional<Socio> ganaciaSocio =  socioRepo.findByGanancias(cedula);
        return  ganaciaSocio.isEmpty();
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
    public Ganancia registrarGanancia(Ganancia g) throws Exception {
        if(g.getSocioGanancia().getCompras()== null){
            throw  new Exception("El socio debe tener una compra asociada");
        }
        if(existeSocio(g.getSocioGanancia().getCedula())){
            throw new Exception("El número de cédula no se encuentra asociado a ningún socio activo");
        }
        if (estadoSocio(g.getSocioGanancia().getCedula() )== EstadoSocio.NO_ACTIVO) {
            throw new Exception("El socio no se encuentra activo");
        }
        if (estadoSocio(g.getSocioGanancia().getCedula()) == EstadoSocio.PENDIENTE) {
            throw new Exception("El socio aun no se encuentra aprobado");
        }

        Ganancia ganancia = gananciaRepo.save(g);
        return ganancia;
    }

    @Override
    public Ganancia actualizarGanancia(Ganancia g) throws Exception {
        if(existeSocio(g.getSocioGanancia().getCedula())){
            throw new Exception("El número de cédula no se encuentra asociado a ningún socio activo");
        }
        if (estadoSocio(g.getSocioGanancia().getCedula() )== EstadoSocio.NO_ACTIVO) {
            throw new Exception("El socio no se encuentra activo");
        }
        if (estadoSocio(g.getSocioGanancia().getCedula()) == EstadoSocio.PENDIENTE) {
            throw new Exception("El socio aun no se encuentra aprobado");
        }

        Ganancia ganancia = gananciaRepo.save(g);
        return ganancia;

    }

    @Override
    public void eliminarGanancia(String cedula) throws Exception {

        if (gananciaSocio(cedula)){
            throw new Exception("El socio no tiene ganancia a borrar");
        }


    }

    @Override
    public List<Ganancia> listarGanancia() {
        return null;
    }
}
