package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Inventario;
import co.edu.uniquindio.proyecto.repositorios.InventarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioServicioImp implements InventarioServicio{

    private final InventarioRepo inventarioRepo;

    public InventarioServicioImp(InventarioRepo inventarioRepo) {
        this.inventarioRepo = inventarioRepo;
    }

    @Override
    public Inventario registrarInventario(Inventario i) throws Exception {
        return null;
    }

    @Override
    public Inventario actualizarInventario(Inventario i) throws Exception {
        return null;
    }

    @Override
    public void eliminarInventario(String cedulaSocio) throws Exception {

    }

    @Override
    public List<Inventario> listarInventario() {
        return null;
    }
}
