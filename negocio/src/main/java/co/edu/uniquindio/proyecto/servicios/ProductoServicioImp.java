package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImp implements ProductoServicio {

    private final ProductoRepo productoRepo;

    public ProductoServicioImp(ProductoRepo productoRepo) {
        this.productoRepo = productoRepo;
    }

    private void validaciones(Producto p) throws Exception {
        if (p.getNombre().isEmpty()) {
            throw new Exception("Debe ingresar un nombre");
        }
        if (p.getNombre().length() > 150) {
            throw new Exception("El nombre del producto no puede tener más de 100 caracteres");
        }
        if (p.getDescripcion().isEmpty()) {
            throw new Exception("Debe ingresar una descripción");
        }
        if (p.getDescripcion().length() >= 250) {
            throw new Exception("La descripción no debe ser mayor a 250 caracteres");
        }
        if (p.getPrecioCompra() == 0.0) {
            throw new Exception("Debe ingresar un precio compra del prodcuto");
        }
        if (p.getPrecioVenta() == 0.0) {
            throw new Exception("Debe ingresar un precio venta del prodcuto");
        }
        if (p.getPrecioCompra() > p.getPrecioVenta()) {
            throw new Exception("El precio de venta debe ser mayor al de compra para obtener ganancias");
        }
    }

    public boolean idDisponible(int id) {
        Optional<Producto> p = productoRepo.findById(id);
        return p.isEmpty();
    }

    @Override
    public Producto registrarProducto(Producto p) throws Exception {
        validaciones(p);
        if (p.getUnidadesDisponibles() == 0) {
            throw new Exception("Debe ingresar la cantidad de unidades disponibles mayor a 0");
        }

        Producto proNew = productoRepo.save(p);
        return proNew;
    }

    @Override
    public Producto actualizarProducto(Producto p) throws Exception {
        if (idDisponible(p.getIdProducto())) {
            throw new Exception("El producto con el id ingresado no se encuentra registrado");
        }
        validaciones(p);
        Producto pAct = productoRepo.save(p);
        return pAct;
    }

    @Override
    public boolean eliminarProducto(int idProducto) throws Exception {
        if (idDisponible(idProducto)) {
            throw new Exception("El producto con el id ingresado no se encuentra registrado");
        }
        Producto p = productoRepo.obtenerProducto(idProducto);
        p.setUnidadesDisponibles(0);
        productoRepo.save(p);

        return true;
    }

    @Override
    public Producto obtenerProducto(int id) throws Exception {
        if(idDisponible(id)){
            throw new Exception("Debe ingresar una id valida");
        }
        return productoRepo.obtenerProducto(id);
    }

    @Override
    public List<Producto> listarProducto() {
        return productoRepo.findAll();
    }

    @Override
    public List<Producto> listarProductosActivos(){
        return productoRepo.obetenerProductosActivos();
    }
}
