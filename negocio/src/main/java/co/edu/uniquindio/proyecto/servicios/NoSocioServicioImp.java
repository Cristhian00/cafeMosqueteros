package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.NoSocio;
import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.repositorios.NoSocioRepo;
import co.edu.uniquindio.proyecto.repositorios.PersonaRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NoSocioServicioImp implements NoSocioServicio {

    private final NoSocioRepo noSocioRepo;
    private final PersonaRepo personaRepo;

    public NoSocioServicioImp(NoSocioRepo noSocioRepo, PersonaRepo personaRepo) {
        this.noSocioRepo = noSocioRepo;
        this.personaRepo = personaRepo;
    }

    public boolean emailDisponible(String correo) {
        Optional<Persona> ns = personaRepo.findByCorreo(correo);
        return ns.isEmpty();
    }

    public boolean cedulaDisponible(String cedula) {
        Optional<Persona> ns = personaRepo.findByCedula(cedula);
        return ns.isEmpty();
    }

    public boolean celularDisponible(String celular) {
        Optional<Persona> ns = personaRepo.findByCelular(celular);
        return ns.isEmpty();
    }

    @Override
    public NoSocio obtenerNoSocio(String cedula) throws Exception {

        if (cedula == null) {
            throw new Exception("Debe ingresar un número de cédula");
        }
        if (cedulaDisponible(cedula)) {
            throw new Exception("El número de cédula no se encuentra registrada en ningún usuario");
        }
        return noSocioRepo.obtenerNoSocioCedula(cedula);
    }

    public void validaciones(NoSocio noSocio) throws Exception {
        //Validaciones de la cédula
        if (noSocio.getCedula() == null || noSocio.getCedula().isEmpty()) {
            throw new Exception("Debe ingresar un número de cédula");
        }
        //Validaciones del correo electronico
        if (noSocio.getCorreo() == null || noSocio.getCorreo().isEmpty()) {
            throw new Exception("Debe ingresar un correo electronico");
        }
        //Otras validaciones
        if (noSocio.getContrasenia() == null || noSocio.getContrasenia().isEmpty()) {
            throw new Exception("Debe ingresar una contraseña");
        }
        if (noSocio.getPrimerNombre() == null || noSocio.getContrasenia().isEmpty()) {
            throw new Exception("Debe ingresar un nombre");
        }
        if (noSocio.getPrimerNombre().length() > 100) {
            throw new Exception("El nombre debe tener un máximo de 100 caracteres");
        }
        if (noSocio.getPrimerApellido() == null || noSocio.getPrimerApellido().isEmpty()) {
            throw new Exception("Debe ingresar un apellido");
        }
        if (noSocio.getPrimerApellido().length() > 100) {
            throw new Exception("El apellido debe tener un máximo de 100 caracteres");
        }
        if (noSocio.getSegundoNombre() != null && !noSocio.getSegundoNombre().isEmpty()) {
            if (noSocio.getSegundoNombre().length() > 100) {
                throw new Exception("El nombre debe tener un máximo de 100 caracteres");
            }
        }
        if (noSocio.getSegundoApellido() != null && !noSocio.getSegundoApellido().isEmpty()) {
            if (noSocio.getSegundoApellido().length() > 100) {
                throw new Exception("El apellido debe tener un máximo de 100 caracteres");
            }
        }
        if (noSocio.getCelular() == null) {
            throw new Exception("Debe ingresar un número de celular");
        }
        if (noSocio.getCelular().length() > 10) {
            throw new Exception("El número de celular debe tener máximo 10 numeros");
        }
        if (!celularDisponible(noSocio.getCelular())) {
            throw new Exception("El celular ya se encuentra registrado en otro usuario");
        }
    }

    @Override
    public NoSocio registrarNoSocio(NoSocio noSocio) throws Exception {
        validaciones(noSocio);
        if (!cedulaDisponible(noSocio.getCedula())) {
            throw new Exception("La cédula ya se encuentra regitrada en otro usuario");
        }
        if (noSocio.getCedula().length() < 6) {
            throw new Exception("El número de la cédula no puede contener menos de 6 caracteres");
        }
        if (noSocio.getCedula().length() > 12) {
            throw new Exception("El número de la cédula no puede contener más de 12 caracteres");
        }
        if (!emailDisponible(noSocio.getCorreo())) {
            throw new Exception("El correo ya se encuentra registrado en otro usuario");
        }
        if (noSocio.getCorreo().length() > 60) {
            throw new Exception("El email puede tener un máximo de 60 caracteres");
        }
        noSocio.setFechaVinculacion(new Date());
        NoSocio NoSocioNew = noSocioRepo.save(noSocio);
        return NoSocioNew;
    }

    @Override
    public NoSocio actualizarNoSocio(NoSocio noSocio) throws Exception {
        validaciones(noSocio);
        if (cedulaDisponible(noSocio.getCedula())) {
            throw new Exception("La cédula no se encuentra registrada a ningún usuario");
        }
        if (!obtenerNoSocio(noSocio.getCedula()).getCorreo().equals(noSocio.getCorreo())) {
            if (!emailDisponible(noSocio.getCorreo())) {
                throw new Exception("El correo ya se encuentra registrado en otro usuario");
            }
        }
        NoSocio ns = noSocioRepo.save(noSocio);
        return ns;
    }

    @Override
    public void eliminarNoSocio(String cedula) throws Exception {
        NoSocio noSocio = obtenerNoSocio(cedula);
        if (noSocio.getCedula() == null) {
            throw new Exception("Debe ingresar un número de cédula");
        }
        if (cedulaDisponible(noSocio.getCedula())) {
            throw new Exception("El número de cédula no se encuentra registrada en ningún usuario");
        }

        noSocioRepo.delete(noSocio);
    }

    @Override
    public List<NoSocio> listarNoSocio() {
        return noSocioRepo.findAll();
    }
}
