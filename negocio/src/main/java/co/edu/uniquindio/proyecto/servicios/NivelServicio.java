package co.edu.uniquindio.proyecto.servicios;



import co.edu.uniquindio.proyecto.entidades.Nivel;

import java.util.List;

public interface NivelServicio {

    Nivel registrarNivel( Nivel n) throws Exception;

    Nivel actualizarNivel( Nivel n) throws Exception;

    void eliminarNivel(int numeroNivel) throws Exception;

    List< Nivel> listarNivel();
}
