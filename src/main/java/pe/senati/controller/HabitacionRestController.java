package pe.senati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.senati.entity.Habitacion;
import pe.senati.service.HabitacionService;
import java.util.Collection;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionRestController {

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping("/listar")
    public ResponseEntity<Collection<Habitacion>> listar() {
        return new ResponseEntity<>(habitacionService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrar(@RequestBody Habitacion habitacion) {
        habitacionService.insert(habitacion);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/editar/{habitacionId}")
    public ResponseEntity<Void> editar(@PathVariable Integer habitacionId, @RequestBody Habitacion habitacion) {
        habitacion.setHabitacionId(habitacionId);
        habitacionService.update(habitacion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{habitacionId}")
    public ResponseEntity<Void> borrar(@PathVariable Integer habitacionId) {
        habitacionService.delete(habitacionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/buscar/{habitacionId}")
    public ResponseEntity<Habitacion> buscar(@PathVariable Integer habitacionId) {
        Habitacion habitacion = habitacionService.findById(habitacionId);
        return new ResponseEntity<>(habitacion, habitacion != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar-por-numero/{numero}")
    public ResponseEntity<Habitacion> buscarPorNumero(@PathVariable String numero) {
        Habitacion habitacion = habitacionService.findByNumero(numero);
        return new ResponseEntity<>(habitacion, habitacion != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}