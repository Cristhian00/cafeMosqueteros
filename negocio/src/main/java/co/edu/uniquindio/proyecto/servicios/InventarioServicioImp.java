package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Inventario;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Socio;
import co.edu.uniquindio.proyecto.repositorios.InventarioRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.SocioRepo;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class InventarioServicioImp implements InventarioServicio {

    private final InventarioRepo inventarioRepo;
    private final SocioRepo socioRepo;
    private final ProductoRepo productoRepo;

    public InventarioServicioImp(InventarioRepo inventarioRepo, SocioRepo socioRepo, ProductoRepo productoRepo) {
        this.inventarioRepo = inventarioRepo;
        this.socioRepo = socioRepo;
        this.productoRepo = productoRepo;
    }

    public boolean existeSocio(Socio s) {
        Optional<Socio> socio = socioRepo.findById(s.getCedula());
        return socio.isPresent();
    }

    public boolean existeProducto(Producto p) {
        Optional<Producto> producto = productoRepo.findById(p.getIdProducto());
        return producto.isPresent();
    }

    public int unidadesDisponibles(Producto p) {
        Producto producto = productoRepo.obtenerProducto(p.getIdProducto());
        return producto.getUnidadesDisponibles();
    }

    public boolean existeInventario(Socio s, Producto p) {
        Optional<Inventario> inventario = inventarioRepo.findBySocioInventarioAndProductoInventario(s, p);
        return inventario.isPresent();
    }

    public void validaciones(Inventario i) throws Exception {
        if (i.getSocioInventario() == null) {
            throw new Exception("Debe ingresar el socio al que pertenezca el inventario");
        }
        if (!existeSocio(i.getSocioInventario())) {
            throw new Exception("El socio al que se le va a registrar el inventario no se encuentra registrado");
        }
        if (i.getProductoInventario() == null) {
            throw new Exception("Debe ingresar un producto al que pertenezca el inventario");
        }
        if (!existeProducto(i.getProductoInventario())) {
            throw new Exception("El producto al que se le va a registrar el inventario no se encuentra registrado");
        }
        if (unidadesDisponibles(i.getProductoInventario()) < i.getCantidad()) {
            throw new Exception("La cantidad del inventario no puede sobrepasar la cantidad de unidades disponibles");
        }
    }

    @Override
    public Inventario registrarInventario(Inventario i) throws Exception {

        validaciones(i);
        if (i.getCantidad() <= 0) {
            throw new Exception("Para registrar un inventario la cantidad debe ser mayor o igual a uno");
        }
        if (existeInventario(i.getSocioInventario(), i.getProductoInventario())) {
            throw new Exception("El inventario ya se encuentra registrado");
        }

        Inventario inventario = inventarioRepo.save(i);
        Producto productoAux = productoRepo.obtenerProducto(i.getProductoInventario().getIdProducto());
        productoAux.setUnidadesDisponibles(productoAux.getUnidadesDisponibles() - i.getCantidad());
        productoRepo.save(productoAux);

        return inventario;
    }

    @Override
    public Inventario actualizarInventario(Inventario i) throws Exception {

        validaciones(i);
        if (i.getCantidad() < 0) {
            throw new Exception("La cantidad debe ser mayor o igual a cero");
        }
        if (!existeInventario(i.getSocioInventario(), i.getProductoInventario())) {
            throw new Exception("El inventario no se encuentra registrado");
        }
        Inventario inventario = inventarioRepo.save(i);
        Producto productoAux = productoRepo.obtenerProducto(i.getProductoInventario().getIdProducto());
        productoAux.setUnidadesDisponibles(productoAux.getUnidadesDisponibles() - i.getCantidad());
        productoRepo.save(productoAux);

        return inventario;
    }

    @Override
    public boolean eliminarInventario(String cedula, Producto producto) throws Exception {
        if(cedula==null){
            throw new Exception("Debe ingresar la cedula del socio a eliminar el inventario");
        }
        if(producto==null){
            throw new Exception("Debe ingresar un producto par eliminar el inventario");
        }
        Socio s = socioRepo.obtenerUsuarioCedula(cedula);
        if (!existeInventario(s, producto)) {
            throw new Exception("El inventario no se encuentra registrado");
        }

        inventarioRepo.delete(inventarioRepo.obtenerSocioInventarioAndProductoInventario(s, producto));
        return true;
    }

    @Override
    public List<Inventario> listarInventario() {
        return null;
    }
}
