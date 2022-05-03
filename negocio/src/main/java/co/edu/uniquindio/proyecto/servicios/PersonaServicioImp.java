package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.EstadoSocio;
import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.entidades.Socio;
import co.edu.uniquindio.proyecto.repositorios.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Transactional
@Service
public class PersonaServicioImp implements PersonaServicio {

    @Autowired
    private final PersonaRepo personaRepo;

    public PersonaServicioImp(PersonaRepo personaRepo) {
        this.personaRepo = personaRepo;
    }


    @Override
    public Persona login(String correo, String contrasenia) throws Exception {

        Optional<Persona> persona = personaRepo.findByCorreoAndContrasenia(correo, contrasenia);

        if(persona.isEmpty()){
            throw new Exception("Los datos de autenticación son incorrectos");
        }

        if(persona.get() instanceof Socio){
            Socio s = (Socio) persona.get();
            if(s.getEstado() == EstadoSocio.NO_ACTIVO){
                throw new Exception("El socio no se puede iniciar sesicón porque se encuentra no activo");
            }
        }
        return persona.get();
    }

    @Override
    public Persona recuperarContrasenia(String cedula, String correo) throws Exception {

        Optional<Persona> persona = personaRepo.findByCedulaAndCorreo(cedula,correo);

        if(persona.isEmpty()){
            throw new Exception("Los datos de no son correctos o no pertenecen a un usuario registrado");
        }
        return persona.get();
    }
}
