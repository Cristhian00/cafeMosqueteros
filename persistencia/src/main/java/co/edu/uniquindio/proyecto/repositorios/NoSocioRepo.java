package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.NoSocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoSocioRepo extends JpaRepository<NoSocio, String> {

    Optional<NoSocio> findByCorreo(String correo);
    Optional<NoSocio> findByCedula (String cedula);

    @Query ("SELECT ns FROM NoSocio ns WHERE  ns.cedula = ?1")
    NoSocio obtenerNoSocioCedula (String cedula);
}
