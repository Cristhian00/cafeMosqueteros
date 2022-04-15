package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServicioImp implements  CompraServicio {

    private final CompraRepo compraRepo;

    public CompraServicioImp(CompraRepo compraRepo) {
        this.compraRepo = compraRepo;
    }

    @Override
    public Compra registrarCompra(Compra c) throws Exception {
        return null;
    }

    @Override
    public Compra actualizarCompra(Compra c) throws Exception {
        return null;
    }

    @Override
    public void eliminarCompra(int idCompra) throws Exception {

    }

    @Override
    public List<Compra> listarCompra() {
        return null;
    }
}
