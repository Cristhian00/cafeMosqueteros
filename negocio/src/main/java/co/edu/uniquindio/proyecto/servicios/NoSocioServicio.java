package co.edu.uniquindio.proyecto.servicios;



import co.edu.uniquindio.proyecto.entidades.NoSocio;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoSocioServicio {

    NoSocio registrarNoSocio(NoSocio noSocio) throws Exception;

    NoSocio actualizarNoSocio(NoSocio noSocio) throws Exception;

    void eliminarNoSocio(String cedula) throws Exception;

    NoSocio obtenerNoSocio(String cedula) throws Exception;

    List<NoSocio> listarNoSocio();
}
