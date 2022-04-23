package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.entidades.PersonaServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaServicioRepo extends JpaRepository<PersonaServicio,String> {

    PersonaServicio findByCorreoAndAndContrasenia(String correo, String contrasenia);
}
