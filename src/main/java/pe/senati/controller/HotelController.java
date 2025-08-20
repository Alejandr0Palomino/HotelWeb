package pe.senati.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pe.senati.entity.Hotel;
import pe.senati.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/listar")
    public String listar_GET(Model model) {
        model.addAttribute("bHoteles", hotelService.findAll());
        return "Hotel/Listar";
    }

    @GetMapping("/registrar")
    public String registrar_GET(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "Hotel/Registrar";
    }

    @PostMapping("/registrar")
    public String registrar_POST(@ModelAttribute Hotel hotel) {
        hotelService.insert(hotel);
        return "redirect:/hotel/listar"; 
    }
    
    @GetMapping("/editar/{hotelId}")
    public String editar_GET(
        Model model,
        @PathVariable Integer hotelId
    ) {
        Hotel hotelModel = hotelService.findById(hotelId);
        model.addAttribute("hotel", hotelModel);
        return "Hotel/Editar";
    }

    @PostMapping("/editar/{hotelId}")
    public String editar_POST(
        @ModelAttribute Hotel hotel
    ) {
        hotelService.update(hotel);
        return "redirect:/hotel/listar";
    }
    
    @GetMapping("/borrar/{hotelId}")
    public String borrar_GET(
        Model model,
        @PathVariable Integer hotelId
    ) {
        Hotel hotel = hotelService.findById(hotelId);
        model.addAttribute("hotel", hotel);
        return "Hotel/Borrar";
    }

    @PostMapping("/borrar/{hotelId}")
    public String borrar_POST(
        @PathVariable Integer hotelId
    ) {
        hotelService.delete(hotelId);
        return "redirect:/hotel/listar";
    }
    
    @GetMapping("/habitaciones/{hotelId}")
    public String habitaciones_GET(
        Model model,
        @PathVariable Integer hotelId
    ) {
        // Implementar lógica para mostrar habitaciones del hotel
        return "Hotel/Habitaciones"; // Crear esta vista adicional si es necesario
    }
}