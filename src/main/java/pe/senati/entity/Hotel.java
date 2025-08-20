package pe.senati.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "hoteles")
public class Hotel implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Integer hotelId;
    
    @Column(length = 50, nullable = false)
    private String nombre;
    
    @Column(length = 100, nullable = false)
    private String direccion;
    
    @Column(nullable = false)
    private Integer estrellas;
    
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Habitacion> habitaciones = new ArrayList<>();
    
    public Hotel() {
    }

    public Hotel(String nombre, String direccion, Integer estrellas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.estrellas = estrellas;
    }

    // Getters y Setters
    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
}