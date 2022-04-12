package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Ganancia;
import co.edu.uniquindio.proyecto.entidades.LlaveGanancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GananciaRepo extends JpaRepository<Ganancia, LlaveGanancia> {
}
