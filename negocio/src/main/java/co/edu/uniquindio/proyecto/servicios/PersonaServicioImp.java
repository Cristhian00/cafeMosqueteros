package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Persona;
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
    public Persona login(String emailOrNick, String contrasenia) throws Exception {

        Optional<Persona> persona = personaRepo.findByCorreoAndContrasenia(emailOrNick,contrasenia);

        if(persona.isEmpty()){
            throw new Exception("Los datos de autenticación son incorrectos");
        }
        return persona.get();
    }

    @Override
    public Persona recuperarContrasenia(String cedula, String email) throws Exception {

        Optional<Persona> persona = personaRepo.findByCedulaAndCorreo(cedula,email);

        if(persona.isEmpty()){
            throw new Exception("Los datos de no son correctos o no pertenecen a un usuario registrado");
        }
        return persona.get();
    }
}
