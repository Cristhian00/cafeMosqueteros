package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Inventario;
import co.edu.uniquindio.proyecto.entidades.LlaveInventario;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventarioRepo extends JpaRepository<Inventario, LlaveInventario> {

    Optional<Inventario> findBySocioInventarioAndProductoInventario(Socio socio, Producto producto);

    @Query("SELECT i FROM Inventario i WHERE i.socioInventario = ?1 AND i.productoInventario = ?2")
    Inventario obtenerSocioInventarioAndProductoInventario(Socio socio, Producto producto);
}
