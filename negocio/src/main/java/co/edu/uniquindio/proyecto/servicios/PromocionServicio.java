package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.Promocion;

import java.util.List;

public interface PromocionServicio {

    Promocion registrarPromocion(Promocion promocion) throws Exception;

    Promocion actualizarPromocion(Promocion promocion) throws Exception;

    void eliminarPromocion(int idPromocion) throws Exception;

    List<Promocion> listarPromocion();
}
