package pe.senati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.senati.entity.Pago;
import pe.senati.entity.Reserva;
import pe.senati.service.PagoService;

@Controller
@RequestMapping("/pago")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping("/listar")
    public String listar_GET(Model model) {
        model.addAttribute("bPagos", pagoService.findAll());
        return "Pago/Listar";
    }

    @GetMapping("/registrar")
    public String registrar_GET(Model model) {
        model.addAttribute("pago", new Pago());
        return "Pago/Registrar";
    }

    @PostMapping("/registrar")
    public String registrar_POST(@ModelAttribute Pago pago) {
        pagoService.insert(pago);
        return "redirect:/pago/listar";
    }

    @GetMapping("/editar/{pagoId}")
    public String editar_GET(@PathVariable Integer pagoId, Model model) {
        Pago pagoModel = pagoService.findById(pagoId);
        model.addAttribute("pago", pagoModel);
        return "Pago/Editar";
    }

    @PostMapping("/editar/{pagoId}")
    public String editar_POST(@ModelAttribute Pago pago) {
        pagoService.update(pago);
        return "redirect:/pago/listar";
    }

    @GetMapping("/borrar/{pagoId}")
    public String borrar_GET(@PathVariable Integer pagoId, Model model) {
        Pago pago = pagoService.findById(pagoId);
        model.addAttribute("pago", pago);
        return "Pago/Borrar";
    }

    @PostMapping("/borrar/{pagoId}")
    public String borrar_POST(@PathVariable Integer pagoId) {
        pagoService.delete(pagoId);
        return "redirect:/pago/listar";
    }
}
