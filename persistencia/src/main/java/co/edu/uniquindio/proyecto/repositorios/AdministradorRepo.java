package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador, String> {

    Optional<Administrador> findByCorreo(String correo);

    Optional<Administrador> findByCorreoAndContrasenia(String correo, String contrasenia);

    @Query("SELECT a FROM Administrador a WHERE a.correo = ?1 AND a.contrasenia = ?2")
    Optional<Administrador> obtenAdmin(String correo, String contrasenia);
}
