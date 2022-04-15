package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicioImp implements ProductoServicio{

    private final ProductoRepo productoRepo;

    public ProductoServicioImp(ProductoRepo productoRepo) {
        this.productoRepo = productoRepo;
    }

    @Override
    public Producto registrarProducto(Producto producto) throws Exception {
        return null;
    }

    @Override
    public Producto actualizarProducto(Producto producto) throws Exception {
        return null;
    }

    @Override
    public void eliminarProducto(int idProducto) throws Exception {

    }

    @Override
    public List<Producto> listarProducto() {
        return null;
    }
}
