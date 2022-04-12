package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.Column;
import java.io.Serializable;

public class LlaveDetalleCompra implements Serializable {

    private Producto productoDetalle;

    private Compra compraDetalle;
}
