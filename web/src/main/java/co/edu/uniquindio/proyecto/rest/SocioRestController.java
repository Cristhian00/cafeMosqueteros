package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.dto.Mensaje;
import co.edu.uniquindio.proyecto.entidades.Socio;
import co.edu.uniquindio.proyecto.servicios.SocioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/socio")
public class SocioRestController {

    @Autowired
    private SocioServicio socioServicio;

    @GetMapping
    public List<Socio> listarSocios() {
        return socioServicio.listarSocio();
    }

    @GetMapping("/id/{cedula}")
    public ResponseEntity<?> obtenerSocio(@PathVariable(name = "cedula") String cedula) {
        try {
            return ResponseEntity.status(200).body(socioServicio.obtenerSocio(cedula));
        } catch (Exception e) {
            return ResponseEntity.status(500).body((new Mensaje(e.getMessage())));
        }
    }

    @PostMapping
    public ResponseEntity<Mensaje> crearSocio(@RequestBody Socio socio) {
        try {
            socioServicio.registrarSocio(socio);
            return ResponseEntity.status(201).body((new Mensaje("El socio se a registrado correctamente")));
        } catch (Exception e) {
            return ResponseEntity.status(500).body((new Mensaje(e.getMessage())));
        }
    }

    @DeleteMapping("/eliminar/{cedula}")
    public ResponseEntity<Mensaje> eliminarSocio(@PathVariable(name = "cedula") String cedula) {
        try {
            socioServicio.eliminarSocio(cedula);
            return ResponseEntity.status(200).body((new Mensaje("El socio se a eliminado correctamente")));
        } catch (Exception e) {
            return ResponseEntity.status(500).body((new Mensaje(e.getMessage())));
        }
    }

    @PutMapping("/actualizar/{cedula}")
    public ResponseEntity<Mensaje> actualizarSocio(@RequestBody Socio socio) {
        try{
            socioServicio.actualizarSocio(socio);
            return ResponseEntity.status(200).body((new Mensaje("El socio se a actualizado correctamente")));
        }catch (Exception e){
            return ResponseEntity.status(500).body((new Mensaje(e.getMessage())));
        }
    }
}
