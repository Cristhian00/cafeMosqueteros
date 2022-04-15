package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.HistorialJerarquia;
import co.edu.uniquindio.proyecto.entidades.Jerarquia;
import co.edu.uniquindio.proyecto.entidades.LlaveHistorial;
import co.edu.uniquindio.proyecto.entidades.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialJerarquiaRepo extends JpaRepository<HistorialJerarquia, LlaveHistorial> {

    HistorialJerarquia findBySocioHistorialAndJerarquiahistorial(Socio socio, Jerarquia jerarquia);
}
