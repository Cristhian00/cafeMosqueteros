package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Persona;

public interface PersonaServicio {
    Persona login(String correo, String contrasenia) throws Exception;
    Persona recuperarContrasenia (String cedula,String correo) throws  Exception;
}
