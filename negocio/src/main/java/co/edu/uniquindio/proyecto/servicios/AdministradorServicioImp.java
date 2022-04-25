package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.repositorios.AdministradorRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorServicioImp implements AdministradorServicio {

    private final AdministradorRepo administradorRepo;

    public AdministradorServicioImp(AdministradorRepo administradorRepo) {
        this.administradorRepo = administradorRepo;
    }

    @Override
    public Administrador login(String correo, String contrasenia) throws Exception {

        Optional<Administrador> admin = administradorRepo.obtenAdmin(correo, contrasenia);
        if(admin.isEmpty()){
            return null;
        }
        return admin.get();
    }

    @Override
    public Administrador registrarAdministrador(Administrador a) throws Exception {

        if(a.getCorreo() == null && a.getContrasenia() == null){
            throw new Exception("Debe ingresar un correo y contraseña");
        }
        Administrador admin = administradorRepo.save(a);
        return admin;
    }
}
