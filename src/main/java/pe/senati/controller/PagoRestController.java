package pe.senati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.senati.entity.Pago;
import pe.senati.service.PagoService;
import java.util.Collection;

@RestController
@RequestMapping("/api/pagos")
public class PagoRestController {

    @Autowired
    private PagoService pagoService;

    @GetMapping("/listar")
    public ResponseEntity<Collection<Pago>> listar() {
        return new ResponseEntity<>(pagoService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrar(@RequestBody Pago pago) {
        pagoService.insert(pago);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/editar/{pagoId}")
    public ResponseEntity<Void> editar(@PathVariable Integer pagoId, @RequestBody Pago pago) {
        pago.setPagoId(pagoId);
        pagoService.update(pago);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{pagoId}")
    public ResponseEntity<Void> borrar(@PathVariable Integer pagoId) {
        pagoService.delete(pagoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/buscar/{pagoId}")
    public ResponseEntity<Pago> buscar(@PathVariable Integer pagoId) {
        Pago pago = pagoService.findById(pagoId);
        return new ResponseEntity<>(pago, pago != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}