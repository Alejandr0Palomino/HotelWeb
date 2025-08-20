package pe.senati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.senati.entity.Cliente;
import pe.senati.service.ClienteService;
import java.util.Collection;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public ResponseEntity<Collection<Cliente>> listar() {
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrar(@RequestBody Cliente cliente) {
        if(!clienteService.existsByEmail(cliente.getEmail())) {
            clienteService.insert(cliente);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("/editar/{clienteId}")
    public ResponseEntity<Void> editar(@PathVariable Integer clienteId, @RequestBody Cliente cliente) {
        cliente.setClienteId(clienteId);
        clienteService.update(cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{clienteId}")
    public ResponseEntity<Void> borrar(@PathVariable Integer clienteId) {
        clienteService.delete(clienteId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/buscar/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Integer clienteId) {
        Cliente cliente = clienteService.findById(clienteId);
        return new ResponseEntity<>(cliente, cliente != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}