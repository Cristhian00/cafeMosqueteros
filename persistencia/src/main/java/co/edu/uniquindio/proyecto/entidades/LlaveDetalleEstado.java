package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.Column;
import java.io.Serializable;

public class LlaveDetalleEstado implements Serializable {

    private EstadoCompra estadoDetalle;

    private Compra compraEstado;
}
