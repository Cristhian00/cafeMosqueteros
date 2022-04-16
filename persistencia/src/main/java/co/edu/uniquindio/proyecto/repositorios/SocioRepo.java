package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SocioRepo extends JpaRepository<Socio, String> {

    Optional<Socio> findByCorreo(String correo);

    Optional<Socio> findByCedula(String cedula);

    @Query("SELECT s FROM Socio s WHERE s.cedula = ?1")
    Socio obtenerUsuarioCedula(String cedula);
}
