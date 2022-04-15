package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Promocion;
import co.edu.uniquindio.proyecto.repositorios.PromocionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromocionServicioImp implements PromocionServicio{

    private final PromocionRepo promocionRepo;

    public PromocionServicioImp(PromocionRepo promocionRepo) {
        this.promocionRepo = promocionRepo;
    }

    @Override
    public Promocion registrarPromocion(Promocion promocion) throws Exception {
        return null;
    }

    @Override
    public Promocion actualizarPromocion(Promocion promocion) throws Exception {
        return null;
    }

    @Override
    public void eliminarPromocion(int idPromocion) throws Exception {

    }

    @Override
    public List<Promocion> listarPromocion() {
        return null;
    }
}
