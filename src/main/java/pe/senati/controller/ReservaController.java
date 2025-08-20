package pe.senati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.senati.entity.*;
import pe.senati.service.*;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;
    
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private HabitacionService habitacionService;

    @GetMapping("/listar")
    public String listar_GET(Model model) {
        model.addAttribute("reservas", reservaService.findAll());
        return "Reserva/Listar";
    }

    @GetMapping("/registrar")
    public String registrar_GET(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("habitaciones", habitacionService.findAll());
        return "Reserva/Registrar";
    }

    @PostMapping("/registrar")
    public String registrar_POST(
        @ModelAttribute Reserva reserva,
        @RequestParam("fechaEntrada") String fechaEntrada,
        @RequestParam("fechaSalida") String fechaSalida,
        @RequestParam("clienteId") Integer clienteId,
        @RequestParam("habitacionId") Integer habitacionId
    ) {
        // Asignamos las fechas como String directamente
        reserva.setFechaEntrada(fechaEntrada);
        reserva.setFechaSalida(fechaSalida);
        
        // Creamos objetos relacionados solo con ID
        Cliente cliente = new Cliente();
        cliente.setClienteId(clienteId);
        reserva.setCliente(cliente);
        
        Habitacion habitacion = new Habitacion();
        habitacion.setHabitacionId(habitacionId);
        reserva.setHabitacion(habitacion);
        
        // Insertamos la reserva
        reservaService.insert(reserva);
        return "redirect:/reserva/listar";
    }
    
    @GetMapping("/editar/{id}")
    public String editar_GET(Model model, @PathVariable("id") Integer reservaId) {
        model.addAttribute("reserva", reservaService.findById(reservaId));
        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("habitaciones", habitacionService.findAll());
        return "Reserva/Editar";
    }

    @PostMapping("/editar/{id}")
    public String editar_POST(
        @ModelAttribute Reserva reserva,
        @PathVariable("id") Integer reservaId,
        @RequestParam("fechaEntrada") String fechaEntrada,
        @RequestParam("fechaSalida") String fechaSalida,
        @RequestParam("clienteId") Integer clienteId,
        @RequestParam("habitacionId") Integer habitacionId
    ) {
        // Asignamos el ID de la reserva
        reserva.setReservaId(reservaId);
        
        // Asignamos las fechas como String directamente
        reserva.setFechaEntrada(fechaEntrada);
        reserva.setFechaSalida(fechaSalida);
        
        // Creamos objetos relacionados solo con ID
        Cliente cliente = new Cliente();
        cliente.setClienteId(clienteId);
        reserva.setCliente(cliente);
        
        Habitacion habitacion = new Habitacion();
        habitacion.setHabitacionId(habitacionId);
        reserva.setHabitacion(habitacion);
        
        // Actualizamos la reserva
        reservaService.update(reserva);
        return "redirect:/reserva/listar";
    }
    
    @GetMapping("/borrar/{id}")
    public String borrar_GET(Model model, @PathVariable("id") Integer reservaId) {
        model.addAttribute("reserva", reservaService.findById(reservaId));
        return "Reserva/Borrar";
    }

    @PostMapping("/borrar/{id}")
    public String borrar_POST(@PathVariable("id") Integer reservaId) {
        reservaService.delete(reservaId);
        return "redirect:/reserva/listar";
    }
}