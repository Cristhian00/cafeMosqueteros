package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.dto.SocioNivelDTO;
import co.edu.uniquindio.proyecto.entidades.Ganancia;
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

    @Query("SELECT g FROM Ganancia g WHERE g.anio = ?1 AND g.mes = ?2 AND g.socioGanancia.cedula = ?3")
    Optional<Ganancia> obtenerGanancia(int anio, String mes, String cedula);

    @Query("SELECT s1, s2, s3 " +
            "FROM Socio s0 " +
            "LEFT JOIN Socio s1 ON s1.cedula = s0.padre " +
            "LEFT JOIN Socio s2 ON s2.cedula = s1.padre " +
            "LEFT JOIN Socio s3 ON s3.cedula = s2.padre " +
            "WHERE s0.cedula = ?1")
    SocioNivelDTO obtenerPadres(String idSocio);

    /*@Query("SELECT s, IN_LEVEL " +
            "FROM Socio s WHERE IN_LEVEL BETWEEN 1 AND 3 " +
            "start with cedula=?1 connect by prior s.padre = cedula")
    SocioNivelDTO obtenerAncestros(String idSocio);*/
}
