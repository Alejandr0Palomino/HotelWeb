package pe.senati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.senati.entity.Servicio;
import pe.senati.service.ServicioService;
import java.util.Collection;

@RestController
@RequestMapping("/api/servicios")
public class ServicioRestController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping("/listar")
    public ResponseEntity<Collection<Servicio>> listar() {
        return new ResponseEntity<>(servicioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/buscar-por-nombre/{nombre}")
    public ResponseEntity<Collection<Servicio>> buscarPorNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(servicioService.findByNombre(nombre), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrar(@RequestBody Servicio servicio) {
        servicioService.insert(servicio);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/editar/{servicioId}")
    public ResponseEntity<Void> editar(@PathVariable Integer servicioId, @RequestBody Servicio servicio) {
        servicio.setServicioId(servicioId);
        servicioService.update(servicio);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{servicioId}")
    public ResponseEntity<Void> borrar(@PathVariable Integer servicioId) {
        servicioService.delete(servicioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/buscar/{servicioId}")
    public ResponseEntity<Servicio> buscar(@PathVariable Integer servicioId) {
        Servicio servicio = servicioService.findById(servicioId);
        return new ResponseEntity<>(servicio, servicio != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}