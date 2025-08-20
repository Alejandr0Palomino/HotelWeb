package pe.senati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.senati.entity.Cliente;
import pe.senati.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public String listar_GET(Model model) {
        model.addAttribute("bClientes", clienteService.findAll());
        return "Cliente/Listar";
    }

    @GetMapping("/registrar")
    public String registrar_GET(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "Cliente/Registrar";
    }

    @PostMapping("/registrar")
    public String registrar_POST(@ModelAttribute Cliente cliente) {
        clienteService.insert(cliente);
        return "redirect:/cliente/listar";
    }
    
    @GetMapping("/editar/{clienteId}")
    public String editar_GET(
        Model model,
        @PathVariable Integer clienteId
    ) {
        Cliente clienteModel = clienteService.findById(clienteId);
        model.addAttribute("cliente", clienteModel);
        return "Cliente/Editar";
    }

    @PostMapping("/editar/{clienteId}")
    public String editar_POST(
        @ModelAttribute Cliente cliente
    ) {
        clienteService.update(cliente);
        return "redirect:/cliente/listar";
    }
    
    @GetMapping("/borrar/{clienteId}")
    public String borrar_GET(
        Model model,
        @PathVariable Integer clienteId
    ) {
        Cliente cliente = clienteService.findById(clienteId);
        model.addAttribute("cliente", cliente);
        return "Cliente/Borrar";
    }

    @PostMapping("/borrar/{clienteId}")
    public String borrar_POST(
        @PathVariable Integer clienteId
    ) {
        clienteService.delete(clienteId);
        return "redirect:/cliente/listar";
    }
}