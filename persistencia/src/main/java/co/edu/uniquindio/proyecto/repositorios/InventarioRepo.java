package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Inventario;
import co.edu.uniquindio.proyecto.entidades.LlaveInventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepo extends JpaRepository<Inventario, LlaveInventario> {
}
