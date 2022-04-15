package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Compra;


import java.util.List;

public interface CompraServicio {

    Compra registrarCompra(Compra c) throws Exception;

    Compra actualizarCompra(Compra c) throws Exception;

    void eliminarCompra(int idCompra) throws Exception;

    List<Compra> listarCompra();
}
