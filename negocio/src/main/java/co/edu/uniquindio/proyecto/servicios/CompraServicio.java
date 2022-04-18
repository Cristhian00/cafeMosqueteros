package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Compra;


import java.util.List;

public interface CompraServicio {

    Compra registrarCompra(Compra c) throws Exception;

    boolean eliminarCompra(int idCompra) throws Exception;

    List<Compra> listarCompra();
}
