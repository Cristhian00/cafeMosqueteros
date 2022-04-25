package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Promocion;
import co.edu.uniquindio.proyecto.repositorios.PromocionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromocionServicioImp implements PromocionServicio {

    private final PromocionRepo promocionRepo;

    public PromocionServicioImp(PromocionRepo promocionRepo) {
        this.promocionRepo = promocionRepo;
    }

    public boolean existePromocion(int idPromocion) {
        Optional<Promocion> promocion = promocionRepo.findById(idPromocion);
        return promocion.isEmpty();
    }

    @Override
    public Promocion registrarPromocion(Promocion promocion) throws Exception {

        if (existePromocion(promocion.getIdPromocion())) {
            throw new Exception("La promocion ya existe");
        }
        if (promocion.getDescripcion().length() > 200) {
            throw new Exception("Excediste la cantidad de caracteres");
        }
        if (promocion.getDescuento() < 0) {
            throw new Exception("Los decuentos no pueden ser negativos");
        }

        return promocionRepo.save(promocion);
    }

    @Override
    public Promocion actualizarPromocion(Promocion promocion) throws Exception {
        if (existePromocion(promocion.getIdPromocion())) {
            throw new Exception("La promocion ya existe");
        }
        if (promocion.getDescripcion().length() > 200) {
            throw new Exception("Excediste la cantidad de caracteres");
        }
        if (promocion.getDescuento() < 0) {
            throw new Exception("Los decuentos no pueden ser negativos");
        }

        return promocionRepo.save(promocion);
    }



    @Override
    public void eliminarPromocion(int idPromocion) throws Exception {
       Promocion p = promocionRepo.findByIdPromocion(idPromocion);
        if(existePromocion(p.getIdPromocion())){
            throw  new Exception("La promocion ya existe");
        }
        promocionRepo.delete(p);

    }

    @Override
    public Promocion obtenerPromocion(int id) throws Exception {
        return promocionRepo.findByIdPromocion(id);
    }

    @Override
    public List<Promocion> listarPromocion() {
        return promocionRepo.findAll();
    }
}
