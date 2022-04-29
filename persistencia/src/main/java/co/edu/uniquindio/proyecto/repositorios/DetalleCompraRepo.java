package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.entidades.LlaveDetalleCompra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DetalleCompraRepo extends JpaRepository<DetalleCompra, LlaveDetalleCompra> {

    DetalleCompra findByProductoDetalleAndCompraDetalle(Producto producto, Compra compra);

    @Query("SELECT dc FROM DetalleCompra dc WHERE dc.compraDetalle.idCompra = ?1")
    List<DetalleCompra> obtenerDetallesCompra(int id);

}
