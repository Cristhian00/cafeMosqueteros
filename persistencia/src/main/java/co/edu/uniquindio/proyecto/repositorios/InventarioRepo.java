package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Inventario;
import co.edu.uniquindio.proyecto.entidades.LlaveInventario;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepo extends JpaRepository<Inventario, LlaveInventario> {

    Inventario findBySocioInventarioAndAndProductoInventario(Socio socio, Producto producto);
}
