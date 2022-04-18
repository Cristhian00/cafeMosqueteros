package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.DetalleEstado;

import java.util.List;

public interface DetalleEstadoServicio {

    DetalleEstado registrarDetalleEstado(DetalleEstado detalleEstado) throws Exception;

    List<DetalleEstado> listarDetalleEstado();
}
