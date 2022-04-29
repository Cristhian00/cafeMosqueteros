package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.DetalleEstado;
import co.edu.uniquindio.proyecto.entidades.EstadoCompra;
import co.edu.uniquindio.proyecto.entidades.LlaveDetalleEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleEstadoRepo extends JpaRepository<DetalleEstado, LlaveDetalleEstado> {

    DetalleEstado findByCompraEstadoAndEstadoDetalle(Compra compra, EstadoCompra estado);

    @Query("SELECT d FROM DetalleEstado d WHERE d.compraEstado.idCompra = ?1")
    List<DetalleEstado> obtenerEstadosCompra(int id);
}
