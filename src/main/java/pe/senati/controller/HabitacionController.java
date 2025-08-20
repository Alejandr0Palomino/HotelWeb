package pe.senati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.senati.entity.*;
import pe.senati.service.*;

import java.util.List;

@Controller
@RequestMapping("/habitacion")
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;
    
    @Autowired
    private HotelService hotelService;
    
    @Autowired
    private ServicioService servicioService;

    @GetMapping("/listar")
    public String listar_GET(Model model) {
        model.addAttribute("habitaciones", habitacionService.findAll());
        return "Habitacion/Listar";
    }

    @GetMapping("/registrar")
    public String registrar_GET(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        model.addAttribute("hoteles", hotelService.findAll());
        model.addAttribute("servicios", servicioService.findAll());
        return "Habitacion/Registrar";
    }

    @PostMapping("/registrar")
    public String registrar_POST(
        @ModelAttribute Habitacion habitacion,
        @RequestParam Integer hotelId,
        @RequestParam(required = false) List<Integer> serviciosIds
    ) {
        Hotel hotel = new Hotel();
        hotel.setHotelId(hotelId);
        habitacion.setHotel(hotel);
        
        habitacionService.insert(habitacion);
        
        if(serviciosIds != null) {
            for(Integer servicioId : serviciosIds) {
                Servicio servicio = new Servicio();
                servicio.setServicioId(servicioId);
                habitacion.agregarServicio(servicio);
            }
        }
        
        return "redirect:/habitacion/listar";
    }
    
    @GetMapping("/editar/{id}")
    public String editar_GET(Model model, @PathVariable Integer id) {
        Habitacion habitacion = habitacionService.findById(id);
        model.addAttribute("habitacion", habitacion);
        model.addAttribute("hoteles", hotelService.findAll());
        model.addAttribute("servicios", servicioService.findAll());
        return "Habitacion/Editar";
    }

    @PostMapping("/editar/{id}")
    public String editar_POST(
        @ModelAttribute Habitacion habitacion,
        @RequestParam Integer hotelId,
        @RequestParam(required = false) List<Integer> serviciosIds
    ) {
        Hotel hotel = new Hotel();
        hotel.setHotelId(hotelId);
        habitacion.setHotel(hotel);
        
        habitacionService.update(habitacion);
        
        // Actualizar servicios (implementar lógica según tu necesidad)
        
        return "redirect:/habitacion/listar";
    }
    
    @GetMapping("/borrar/{id}")
    public String borrar_GET(Model model, @PathVariable Integer id) {
        model.addAttribute("habitacion", habitacionService.findById(id));
        return "Habitacion/Borrar";
    }

    @PostMapping("/borrar/{id}")
    public String borrar_POST(@PathVariable Integer id) {
        habitacionService.delete(id);
        return "redirect:/habitacion/listar";
    }
}