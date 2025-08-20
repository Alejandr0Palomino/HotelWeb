package pe.senati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.senati.entity.Reserva;
import pe.senati.service.ReservaService;
import java.util.Collection;

@RestController
@RequestMapping("/api/reservas")
public class ReservaRestController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/listar")
    public ResponseEntity<Collection<Reserva>> listar() {
        return new ResponseEntity<>(reservaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/buscar-por-cliente/{clienteId}")
    public ResponseEntity<Collection<Reserva>> buscarPorCliente(@PathVariable Integer clienteId) {
        return new ResponseEntity<>(reservaService.findByClienteId(clienteId), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrar(@RequestBody Reserva reserva) {
        reservaService.insert(reserva);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/editar/{reservaId}")
    public ResponseEntity<Void> editar(@PathVariable Integer reservaId, @RequestBody Reserva reserva) {
        reserva.setReservaId(reservaId);
        reservaService.update(reserva);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{reservaId}")
    public ResponseEntity<Void> borrar(@PathVariable Integer reservaId) {
        reservaService.delete(reservaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/buscar/{reservaId}")
    public ResponseEntity<Reserva> buscar(@PathVariable Integer reservaId) {
        Reserva reserva = reservaService.findById(reservaId);
        return new ResponseEntity<>(reserva, reserva != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}