package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Distribuidor;
import co.edu.uniquindio.proyecto.repositorios.DistribuidorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistribuidorServicioImp implements  DistribuidorServicio{

    private final DistribuidorRepo distribuidorRepo;

    public DistribuidorServicioImp(DistribuidorRepo distribuidorRepo) {
        this.distribuidorRepo = distribuidorRepo;
    }


    @Override
    public Distribuidor registrarDistribuidor(Distribuidor d) throws Exception {
        return null;
    }

    @Override
    public Distribuidor actualizarDistribuidor(Distribuidor d) throws Exception {
        return null;
    }

    @Override
    public void eliminarDistribuidor(String nitDistribuidor) throws Exception {

    }

    @Override
    public List<Distribuidor> listarDistribuidor() {
        return null;
    }
}
