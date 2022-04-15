package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Distribuidor;
import co.edu.uniquindio.proyecto.repositorios.DistribuidorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistribuidorServicioImp implements  DistribuidorServicio{

    private final DistribuidorRepo distribuidorRepo;

    public DistribuidorServicioImp(DistribuidorRepo distribuidorRepo) {
        this.distribuidorRepo = distribuidorRepo;
    }


    @Override
    public Distribuidor registrarDistribuidor(Distribuidor d) throws Exception {

        Optional<Distribuidor> buscar = distribuidorRepo.findById(d.getNitDistribuidor());

        if(buscar.isPresent()){
            throw new Exception("El nit ya se encuentra registado");
        }else if(d.getNombre().length()> 50){
            throw new Exception("El nombre debe tener como maximo 50 caracteres");
        }

        return distribuidorRepo.save(d);
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
