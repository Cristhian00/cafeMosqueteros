package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.Distribuidor;

import java.util.List;

public interface DistribuidorServicio {

    Distribuidor registrarDistribuidor(Distribuidor d) throws Exception;

    Distribuidor actualizarDistribuidor(Distribuidor d) throws Exception;

    void eliminarDistribuidor(String nitDistribuidor) throws Exception;

    List<Distribuidor> listarDistribuidor();
}
