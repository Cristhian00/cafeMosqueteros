package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.TipoProducto;
import co.edu.uniquindio.proyecto.repositorios.TipoProductoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductoServicioImp implements TipoProductoServicio{

    private final TipoProductoRepo tipoProductoRepo;

    public TipoProductoServicioImp(TipoProductoRepo tipoProductoRepo) {
        this.tipoProductoRepo = tipoProductoRepo;
    }

    @Override
    public TipoProducto registrarTipoProducto(TipoProducto tipoProducto) throws Exception {
        return null;
    }

    @Override
    public TipoProducto actualizarTipoProducto(TipoProducto tipoProducto) throws Exception {
        return null;
    }

    @Override
    public void eliminarTipoProducto(int idTipo) throws Exception {

    }

    @Override
    public List<TipoProducto> listarTipoProducto() {
        return null;
    }
}
