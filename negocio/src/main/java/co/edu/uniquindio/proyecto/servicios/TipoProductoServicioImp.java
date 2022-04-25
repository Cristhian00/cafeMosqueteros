package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.TipoProducto;
import co.edu.uniquindio.proyecto.repositorios.TipoProductoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public TipoProducto obtenerTipo(int id) throws Exception{
        Optional<TipoProducto> tipo = tipoProductoRepo.findById(id);
        if (tipo.isEmpty()) {
            throw new Exception("No existe un tipo resgitrado con ese ID");
        }
        return tipo.get();
    }
}
