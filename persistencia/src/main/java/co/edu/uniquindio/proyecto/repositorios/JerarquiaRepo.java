package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Jerarquia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JerarquiaRepo extends JpaRepository<Jerarquia, Integer> {
    Optional<Jerarquia> findByNombre(String nombre);

    Jerarquia findByIdJerarquia(int idJerarquia);
}
