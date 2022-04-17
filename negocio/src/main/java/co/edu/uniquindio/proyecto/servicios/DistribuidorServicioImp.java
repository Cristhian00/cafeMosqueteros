package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Distribuidor;
import co.edu.uniquindio.proyecto.repositorios.DistribuidorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistribuidorServicioImp implements DistribuidorServicio {

    private final DistribuidorRepo distribuidorRepo;

    public DistribuidorServicioImp(DistribuidorRepo distribuidorRepo) {
        this.distribuidorRepo = distribuidorRepo;
    }

    public boolean existeDistribuidor(String nitDistribuidor) {
        Optional<Distribuidor> buscar = distribuidorRepo.findById(nitDistribuidor);
        return buscar.isEmpty();
    }

    @Override
    public Distribuidor registrarDistribuidor(Distribuidor d) throws Exception {

        if (existeDistribuidor(d.getNitDistribuidor())) {
            throw new Exception("El nit ya se encuentra registado");
        } else if (d.getNombre().length() > 50) {
            throw new Exception("El nombre debe tener como maximo 50 caracteres");
        }

        return distribuidorRepo.save(d);
    }

    @Override
    public Distribuidor actualizarDistribuidor(Distribuidor d) throws Exception {

        if (existeDistribuidor(d.getNitDistribuidor())) {
            throw new Exception("El nit ya se encuentra registado");
        } else if (d.getNombre().length() > 50) {
            throw new Exception("El nombre debe tener como maximo 50 caracteres");
        }

        return distribuidorRepo.save(d);
    }

    @Override
    public void eliminarDistribuidor(String nitDistribuidor) throws Exception {
        Distribuidor d = distribuidorRepo.findByNitDistribuidor(nitDistribuidor);
        if (existeDistribuidor(nitDistribuidor)) {
            throw new Exception("El nit no se encuentra registrado");
        }
        distribuidorRepo.delete(d);
    }

    @Override
    public List<Distribuidor> listarDistribuidor() {
        return distribuidorRepo.findAll();
    }
}
