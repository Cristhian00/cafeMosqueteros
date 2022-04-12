package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.DetalleEstado;
import co.edu.uniquindio.proyecto.entidades.LlaveDetalleEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleEstadoRepo extends JpaRepository<DetalleEstado, LlaveDetalleEstado> {
}
