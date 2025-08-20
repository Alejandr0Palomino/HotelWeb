package pe.senati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.senati.entity.Hotel;
import pe.senati.service.HotelService;
import java.util.Collection;

@RestController
@RequestMapping("/api/hoteles")
public class HotelRestController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/listar")
    public ResponseEntity<Collection<Hotel>> listar() {
        return new ResponseEntity<>(hotelService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/buscar-por-nombre/{nombre}")
    public ResponseEntity<Collection<Hotel>> buscarPorNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(hotelService.findByNombre(nombre), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrar(@RequestBody Hotel hotel) {
        hotelService.insert(hotel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/editar/{hotelId}")
    public ResponseEntity<Void> editar(@PathVariable Integer hotelId, @RequestBody Hotel hotel) {
        hotel.setHotelId(hotelId);
        hotelService.update(hotel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{hotelId}")
    public ResponseEntity<Void> borrar(@PathVariable Integer hotelId) {
        hotelService.delete(hotelId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/buscar/{hotelId}")
    public ResponseEntity<Hotel> buscar(@PathVariable Integer hotelId) {
        Hotel hotel = hotelService.findById(hotelId);
        return new ResponseEntity<>(hotel, hotel != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}