package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.dto.Mensaje;
import co.edu.uniquindio.proyecto.entidades.NoSocio;
import co.edu.uniquindio.proyecto.servicios.NoSocioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/noSocio")
public class NoSocioRestController {

    @Autowired
    private NoSocioServicio noSocioServicio;

    @GetMapping
    public List<NoSocio> listarNoSocios() {
        return noSocioServicio.listarNoSocio();
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<?> obtenerNoSocio(@PathVariable(name = "cedula") String cedula) {
        try {
            return ResponseEntity.status(200).body(noSocioServicio.obtenerNoSocio(cedula));
        } catch (Exception e) {
            return ResponseEntity.status(500).body((new Mensaje(e.getMessage())));
        }
    }

    @PostMapping
    public ResponseEntity<Mensaje> crearNoSocio(@RequestBody NoSocio noSocio) {
        try {
            noSocioServicio.registrarNoSocio(noSocio);
            return ResponseEntity.status(201).body((new Mensaje("El usuario se a registrado correctamente")));
        } catch (Exception e) {
            return ResponseEntity.status(500).body((new Mensaje(e.getMessage())));
        }
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Mensaje> eliminarNoSocio(@PathVariable(name = "cedula") String cedula) {
        try {
            noSocioServicio.eliminarNoSocio(cedula);
            return ResponseEntity.status(200).body((new Mensaje("El usuario se a eliminado correctamente")));
        } catch (Exception e) {
            return ResponseEntity.status(500).body((new Mensaje(e.getMessage())));
        }
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<Mensaje> actualizarNoSocio(@RequestBody NoSocio noSocio) {
        try{
            noSocioServicio.actualizarNoSocio(noSocio);
            return ResponseEntity.status(200).body((new Mensaje("El usuario se a actualizado correctamente")));
        }catch (Exception e){
            return ResponseEntity.status(500).body((new Mensaje(e.getMessage())));
        }
    }
}
