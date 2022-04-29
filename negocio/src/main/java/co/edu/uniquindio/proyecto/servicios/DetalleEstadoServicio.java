package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.DetalleEstado;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetalleEstadoServicio {

    DetalleEstado registrarDetalleEstado(DetalleEstado detalleEstado) throws Exception;

    List<DetalleEstado> listaEstados(int idCompra);

    List<DetalleEstado> listarDetalleEstado();
}
