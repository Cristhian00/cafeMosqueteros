package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Persona;

public interface AdministradorServicio {

    Administrador registrarAdministrador(Administrador a) throws Exception;

    Administrador login(String correo, String contrasenia) throws Exception;
}
