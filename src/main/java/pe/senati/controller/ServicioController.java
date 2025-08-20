package pe.senati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.senati.entity.Servicio;
import pe.senati.service.ServicioService;

@Controller
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping("/listar")
    public String listar_GET(Model model) {
        model.addAttribute("bServicios", servicioService.findAll());
        return "Servicio/Listar"; 
    }

    @GetMapping("/registrar")
    public String registrar_GET(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "Servicio/Registrar";
    }

    @PostMapping("/registrar")
    public String registrar_POST(@ModelAttribute Servicio servicio) {
        servicioService.insert(servicio);
        return "redirect:/servicio/listar";
    }
    
    @GetMapping("/editar/{servicioId}")
    public String editar_GET(
        Model model,
        @PathVariable Integer servicioId
    ) {
        Servicio servicioModel = servicioService.findById(servicioId);
        model.addAttribute("servicio", servicioModel);
        return "Servicio/Editar";
    }

    @PostMapping("/editar/{servicioId}")
    public String editar_POST(
        @ModelAttribute Servicio servicio
    ) {
        servicioService.update(servicio);
        return "redirect:/servicio/listar";
    }
    
    @GetMapping("/borrar/{servicioId}")
    public String borrar_GET(
        Model model,
        @PathVariable Integer servicioId
    ) {
        Servicio servicio = servicioService.findById(servicioId);
        model.addAttribute("servicio", servicio);
        return "Servicio/Borrar";
    }

    @PostMapping("/borrar/{servicioId}")
    public String borrar_POST(
        @PathVariable Integer servicioId
    ) {
        servicioService.delete(servicioId);
        return "redirect:/servicio/listar";
    }
}