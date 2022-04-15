package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Socio;

import java.util.List;

public interface SocioServicio {

    Socio registrarSocio(Socio s) throws Exception;

    Socio actualizarSocio(Socio s) throws Exception;

    void eliminarSocio(String cedula) throws Exception;

    List<Socio> listarSocio();
}
