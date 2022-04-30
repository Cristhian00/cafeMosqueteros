package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer> {

    @Query("SELECT p FROM Producto p WHERE p.idProducto = ?1")
    Producto obtenerProducto(int id);

    @Query("SELECT p FROM Producto p WHERE p.unidadesDisponibles > 0")
    List<Producto> obetenerProductosActivos();
}
