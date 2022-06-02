package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepo extends JpaRepository<Persona,String> {

    Optional<Persona> findByCorreoAndContrasenia(String correo, String contrasenia);

    Optional<Persona> findByCedulaAndCorreo (String cedula , String correo);

    Optional<Persona> findByCedula(String cedula);

    Optional<Persona> findByCorreo(String correo);

    Optional<Persona> findByCelular(String celular);
}
