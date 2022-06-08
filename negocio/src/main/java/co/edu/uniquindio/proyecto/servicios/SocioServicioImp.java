package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.EstadoSocio;
import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.entidades.Socio;
import co.edu.uniquindio.proyecto.repositorios.PersonaRepo;
import co.edu.uniquindio.proyecto.repositorios.SocioRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SocioServicioImp implements SocioServicio {

    private final SocioRepo socioRepo;
    private final PersonaRepo personaRepo;

    public SocioServicioImp(SocioRepo socioRepo, PersonaRepo personaRepo) {
        this.socioRepo = socioRepo;
        this.personaRepo = personaRepo;
    }

    public boolean emailDisponible(String correo) {
        Optional<Persona> s = personaRepo.findByCorreo(correo);
        return s.isEmpty();
    }

    public boolean cedulaDisponible(String cedula) {
        Optional<Persona> s = personaRepo.findByCedula(cedula);
        return s.isEmpty();
    }

    public boolean celularDisponible(String celular) {
        Optional<Persona> ns = personaRepo.findByCelular(celular);
        return ns.isEmpty();
    }

    public void validaciones(Socio s) throws Exception {
        //Validaciones de la cédula
        if (s.getCedula() == null || s.getCedula().isEmpty()) {
            throw new Exception("Debe ingresar un número de cédula");
        }
        //Validaciones del correo electronico
        if (s.getCorreo() == null || s.getCorreo().isEmpty()) {
            throw new Exception("Debe ingresar un correo electronico");
        }
        //Otras validaciones
        if (s.getContrasenia() == null || s.getContrasenia().isEmpty()) {
            throw new Exception("Debe ingresar una contraseña");
        }
        if (s.getPrimerNombre() == null || s.getPrimerNombre().isEmpty()) {
            throw new Exception("Debe ingresar un nombre");
        }
        if (s.getPrimerNombre().length() > 100) {
            throw new Exception("El nombre debe tener un máximo de 100 caracteres");
        }
        if (s.getPrimerApellido() == null || s.getPrimerApellido().isEmpty()) {
            throw new Exception("Debe ingresar un apellido");
        }
        if (s.getPrimerApellido().length() > 100) {
            throw new Exception("El apellido debe tener un máximo de 100 caracteres");
        }
        if (s.getSegundoNombre() != null && !s.getSegundoNombre().isEmpty()) {
            if (s.getSegundoNombre().length() > 100) {
                throw new Exception("El nombre debe tener un máximo de 100 caracteres");
            }
        }
        if (s.getSegundoApellido() != null && !s.getSegundoApellido().isEmpty()) {
            if (s.getSegundoApellido().length() > 100) {
                throw new Exception("El apellido debe tener un máximo de 100 caracteres");
            }
        }
        if (s.getCelular() == null || s.getCelular().isEmpty()) {
            throw new Exception("Debe ingresar un número de celular");
        }
        if (s.getCelular().length() > 10) {
            throw new Exception("El número de celular debe tener máximo 10 numeros");
        }
        if (!celularDisponible(s.getCelular())) {
            throw new Exception("El celular ya se encuentra registrado en otro usuario");
        }
    }

    @Override
    public Socio registrarSocio(Socio s) throws Exception {
        validaciones(s);
        if (!cedulaDisponible(s.getCedula())) {
            throw new Exception("La cédula ya se encuentra regitrada en otro usuario");
        }
        if (s.getCedula().length() < 6) {
            throw new Exception("El número de la cédula no puede contener menos de 6 caracteres");
        }
        if (s.getCedula().length() > 12) {
            throw new Exception("El número de la cédula no puede contener más de 12 caracteres");
        }
        if (!emailDisponible(s.getCorreo())) {
            throw new Exception("El correo ya se encuentra registrado en otro usuario");
        }
        if (s.getCorreo().length() > 60) {
            throw new Exception("El email puede tener un máximo de 60 caracteres");
        }
        s.setEstado(EstadoSocio.PENDIENTE);
        s.setFechaVinculacion(new Date());
        Socio socioNew = socioRepo.save(s);
        return socioNew;
    }

    @Override
    public Socio actualizarSocio(Socio s) throws Exception {
        validaciones(s);
        if (cedulaDisponible(s.getCedula())) {
            throw new Exception("La cédula no se encuentra registrada a ningún usuario");
        }
        if (!obtenerSocio(s.getCedula()).getCorreo().equals(s.getCorreo())) {
            if (!emailDisponible(s.getCorreo())) {
                throw new Exception("El correo ya se encuentra registrado en otro usuario");
            }
        }
        Socio socioAct = socioRepo.save(s);
        return socioAct;
    }

    public Socio obtenerSocio(String cedula) throws Exception {

        if (cedula == null) {
            throw new Exception("Debe ingresar un número de cédula");
        }
        if (cedulaDisponible(cedula)) {
            throw new Exception("El número de cédula no se encuentra registrada en ningún usuario");
        }
        return socioRepo.obtenerUsuarioCedula(cedula);
    }

    @Override
    public boolean eliminarSocio(String cedula) throws Exception {

        if (cedula == null) {
            throw new Exception("Debe ingresar un número de cédula");
        }
        if (cedulaDisponible(cedula)) {
            throw new Exception("El número de cédula no se encuentra registrada en ningún usuario");
        }
        Socio s = socioRepo.obtenerUsuarioCedula(cedula);
        s.setEstado(EstadoSocio.NO_ACTIVO);
        socioRepo.save(s);

        return true;
    }

    @Override
    public List<Socio> listarSocio() {
        return socioRepo.findAll();
    }
}
