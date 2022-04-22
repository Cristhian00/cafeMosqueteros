package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.EstadoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoCompraRepo extends JpaRepository<EstadoCompra, Integer> {

    //@Query("SELECT de FROM DetalleEstado de JOIN  Compra  C ON  de.compraEstado.idCompra = c.idCompra WHERE de.compraEstado.idCompra = ?1")
    //List<EstadoCompra> obtenerEstadoCompra (int id);

    Optional<EstadoCompra> findByNombre(String nombre);

    @Query("SELECT e FROM EstadoCompra e WHERE e.nombre = ?1")
    EstadoCompra obtenerEstadoNombre(String nombre);

    @Query("SELECT e FROM EstadoCompra e WHERE e.idEstado = ?1")
    EstadoCompra obtenerEstado(int id);

    //@Query("SELECT de FROM DetalleEstado de JOIN  Compra  C ON  de.compraEstado.idCompra = c.idCompra WHERE de.compraEstado.fecha = ?2")
    //List<EstadoCompra> obtenerEstadoCompra (Date fecha);
}
