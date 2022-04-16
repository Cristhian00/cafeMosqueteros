package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.EstadoSocio;
import co.edu.uniquindio.proyecto.entidades.Socio;
import co.edu.uniquindio.proyecto.repositorios.SocioRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SocioServicioImp implements SocioServicio {

    private final SocioRepo socioRepo;

    public SocioServicioImp(SocioRepo socioRepo) {
        this.socioRepo = socioRepo;
    }

    public boolean emailDisponible(String correo) {
        Optional<Socio> s = socioRepo.findByCorreo(correo);
        return s.isEmpty();
    }

    public boolean cedulaDisponible(String cedula) {
        Optional<Socio> s = socioRepo.findByCedula(cedula);
        return s.isEmpty();
    }

    @Override
    public Socio registrarSocio(Socio s) throws Exception {
        //Validaciones de la cédula
        if (s.getCedula() == null) {
            throw new Exception("Debe ingresar un número de cédula");
        }
        if (!cedulaDisponible(s.getCedula())) {
            throw new Exception("La cédula ya se encuentra regitrada en otro usuario");
        }
        if (s.getCedula().length() > 12) {
            throw new Exception("El número de la cédula no puede contener más de 12 caracteres");
        }
        //Validaciones del correo electronico
        if (s.getCorreo() == null) {
            throw new Exception("Debe ingresar un correo electronico");
        }
        if (!emailDisponible(s.getCorreo())) {
            throw new Exception("El correo ya se encuentra registrado en otro usuario");
        }
        if (s.getCorreo().length() > 60) {
            throw new Exception("El email puede tener un máximo de 60 caracteres");
        }
        //Otras validaciones
        if (s.getContrasenia() == null) {
            throw new Exception("Debe ingresar una contraseña");
        }
        if (s.getPrimerNombre() == null) {
            throw new Exception("Debe ingresar un nombre");
        }
        if (s.getPrimerNombre().length() > 100) {
            throw new Exception("El nombre debe tener un máximo de 100 caracteres");
        }
        if (s.getPrimerApellido() == null) {
            throw new Exception("Debe ingresar un apellido");
        }
        if (s.getPrimerApellido().length() > 100) {
            throw new Exception("El apellido debe tener un máximo de 100 caracteres");
        }
        if (s.getCelular() == null) {
            throw new Exception("Debe ingresar un número de celular");
        }
        if (s.getCelular().length() > 10) {
            throw new Exception("El número de celular debe tener máximo 10 numeros");
        }
        s.setEstado(EstadoSocio.PENDIENTE);
        s.setFechaVinculacion(new Date());
        Socio socioNew = socioRepo.save(s);
        return socioNew;
    }

    @Override
    public Socio actualizarSocio(Socio s) throws Exception {
        if (s.getCedula() == null) {
            throw new Exception("Debe ingresar un número de cédula");
        }
        if (cedulaDisponible(s.getCedula())) {
            throw new Exception("La cédula no se encuentra registrada a ningún usuario");
        }
        if (s.getCorreo() == null) {
            throw new Exception("Debe ingresar un correo electronico");
        }
        if (!obtenerSocio(s.getCedula()).getCorreo().equals(s.getCorreo())) {
            if (!emailDisponible(s.getCorreo())) {
                throw new Exception("El correo ya se encuentra registrado en otro usuario");
            }
        }
        if (s.getCorreo().length() > 60) {
            throw new Exception("El correo puede tener un máximo de 60 caracteres");
        }
        if (s.getPrimerNombre() == null) {
            throw new Exception("Debe ingresar un nombre");
        }
        if (s.getPrimerNombre().length() > 100) {
            throw new Exception("El nombre debe tener un máximo de 100 caracteres");
        }
        if (s.getSegundoNombre() != null) {
            if (s.getSegundoNombre().length() > 100) {
                throw new Exception("El nombre debe tener un máximo de 100 caracteres");
            }
        }
        if (s.getPrimerApellido() == null) {
            throw new Exception("Debe ingresar un apellido");
        }
        if (s.getPrimerApellido().length() > 100) {
            throw new Exception("El apellido debe tener un máximo de 100 caracteres");
        }
        if (s.getSegundoApellido() != null) {
            if (s.getSegundoApellido().length() > 100) {
                throw new Exception("El apellido debe tener un máximo de 100 caracteres");
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
