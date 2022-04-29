package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.EstadoCompra;
import co.edu.uniquindio.proyecto.repositorios.EstadoCompraRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoCompraServicioImp implements EstadoCompraServicio {

    private final EstadoCompraRepo estadoCompraRepo;

    public EstadoCompraServicioImp(EstadoCompraRepo estadoCompraRepo) {
        this.estadoCompraRepo = estadoCompraRepo;
    }

    public boolean existeEstado(String nombre) {
        Optional<EstadoCompra> estado = estadoCompraRepo.findByNombre(nombre);
        return estado.isPresent();
    }

    public boolean existeEstado(int id) {
        Optional<EstadoCompra> estado = estadoCompraRepo.findById(id);
        return estado.isPresent();
    }

    public EstadoCompra obtenerEstado(int id){
        return estadoCompraRepo.obtenerEstado(id);
    }

    public void validaciones(EstadoCompra e) throws Exception{
        if (e.getNombre() == null) {
            throw new Exception("Debe de ingresar un nombre al estado");
        }
        if (e.getNombre().length() > 100) {
            throw new Exception("El nombre del estado debe ser menor a 100");
        }
    }

    @Override
    public EstadoCompra registrarEstadoCompra(EstadoCompra e) throws Exception {

        validaciones(e);
        if (existeEstado(e.getNombre())) {
            throw new Exception("Ya existe un estado con el mismo nombre");
        }

        EstadoCompra estado = estadoCompraRepo.save(e);
        return estado;
    }

    @Override
    public EstadoCompra actualizarEstadoCompra(EstadoCompra e) throws Exception {

        validaciones(e);
        if (existeEstado(e.getIdEstado())){
            if(!obtenerEstado(e.getIdEstado()).getNombre().equalsIgnoreCase(e.getNombre())){
                if (existeEstado(e.getNombre())){
                    throw new Exception("El nombre que se va a actualiar ya existe en otro estado");
                }
            }
        }

        EstadoCompra estado = estadoCompraRepo.save(e);
        return estado;
    }

    @Override
    public boolean eliminarEstadoCompra(int idEstado) throws Exception {
        if (!existeEstado(idEstado)) {
            throw new Exception("No existe un estado con ese id");
        }

        EstadoCompra estado = obtenerEstado(idEstado);
        estadoCompraRepo.delete(estado);
        return true;
    }

    @Override
    public EstadoCompra obtenerEstado(String nombre) throws Exception{
        if(nombre == null){
            throw new Exception("Debe ingresar un nombre");
        }
        if (!existeEstado(nombre)){
            throw new Exception("No existe un estado con ese nombre");
        }
        return estadoCompraRepo.obtenerEstadoNombre(nombre);
    }

    @Override
    public List<EstadoCompra> listarEstadoCompra() {
        return estadoCompraRepo.findAll();
    }
}
