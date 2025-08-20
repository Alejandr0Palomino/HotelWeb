package pe.senati.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/index")
    public String inicio() {
        return "index"; // Solo el nombre de la vista, sin ruta completa
    }
}