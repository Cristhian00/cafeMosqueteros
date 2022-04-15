package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleCompraServicioImp implements  DetalleCompraServicio{

    private final DetalleCompraRepo detalleCompraRepo;

    public DetalleCompraServicioImp(DetalleCompraRepo detalleCompraRepo) {
        this.detalleCompraRepo = detalleCompraRepo;
    }

    @Override
    public DetalleCompra registrarDetalleCompra(DetalleCompra c) throws Exception {
        return null;
    }

    @Override
    public DetalleCompra actualizarDetalleCompra(DetalleCompra c) throws Exception {
        return null;
    }

    @Override
    public void eliminarDetalleCompra(int idCompra) throws Exception {

    }

    @Override
    public List<DetalleCompra> listarDetalleCompra() {
        return null;
    }
}
