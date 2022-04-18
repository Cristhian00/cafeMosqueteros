package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.dto.SocioNivelDTO;
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

    Optional<Socio> findByGanancias(String cedula);

    @Query("SELECT s0.cedula AS lev0, s1.cedula AS lev1, s2.cedula AS lev2, s3.cedula AS lev3 " +
            "FROM Socio s0 " +
            "LEFT JOIN Socio s1 ON s1.cedula = s0.padre " +
            "LEFT JOIN Socio s2 ON s2.cedula = s1.padre " +
            "LEFT JOIN Socio s3 ON s3.cedula = s2.padre " +
            "WHERE s0.cedula = ?1")
    SocioNivelDTO obtenerniveles(String idSocio);
}
