package pe.senati.dto;

import java.math.BigDecimal;

public class HabitacionDto {
    private Integer habitacionId;
    private String numero;
    private String tipo;
    private BigDecimal precio;
    private Integer hotelId;
    private String hotelNombre;
    
    // Getters y Setters
    public Integer getHabitacionId() { return habitacionId; }
    public void setHabitacionId(Integer habitacionId) { this.habitacionId = habitacionId; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public Integer getHotelId() { return hotelId; }
    public void setHotelId(Integer hotelId) { this.hotelId = hotelId; }
    public String getHotelNombre() { return hotelNombre; }
    public void setHotelNombre(String hotelNombre) { this.hotelNombre = hotelNombre; }
}