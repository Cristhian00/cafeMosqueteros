package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.dto.Mensaje;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.servicios.CompraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/compra")
public class CompraRestController {

    @Autowired
    private CompraServicio compraServicio;

    @GetMapping
    public List<Compra> listar() {
        return compraServicio.listarCompra();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Integer id) {
        try {
            return ResponseEntity.status(201).body(compraServicio.obtenerCompra(id));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }

    }

    @PostMapping
    public ResponseEntity<Mensaje> registrar(@RequestBody Compra compra) {
        try {
            compraServicio.registrarCompra(compra);
            return ResponseEntity.status(201).body(new Mensaje("La compra se registro correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Mensaje> actualizar(@RequestBody Compra compra) {

        try {
            //compraServicio.actualizarProducto(producto);
            return ResponseEntity.status(200).body(new Mensaje("la compra se actualizo correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }

    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable(name = "id") int id) {

        try {
            compraServicio.eliminarCompra(id);
            return ResponseEntity.status(200).body(new Mensaje("La compra se elimino correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }
}
