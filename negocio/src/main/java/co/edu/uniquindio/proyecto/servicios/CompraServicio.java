package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.EstadoCompra;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface CompraServicio {

    Compra registrarCompra(Compra c) throws Exception;

    boolean eliminarCompra(int idCompra) throws Exception;

    Compra actualizarEstadoCompra(int idCompra, EstadoCompra estado) throws Exception;

    @Query("SELECT c FROM Compra c WHERE c.idCompra = ?1")
    Compra obtenerCompra(int id) throws Exception;

    List<Compra> listarCompra();
}
