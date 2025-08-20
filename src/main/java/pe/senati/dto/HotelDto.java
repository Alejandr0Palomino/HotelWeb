package pe.senati.dto;

public class HotelDto {
    private Integer hotelId;
    private String nombre;
    private String direccion;
    private Integer estrellas;
    
    // Getters y Setters
    public Integer getHotelId() { return hotelId; }
    public void setHotelId(Integer hotelId) { this.hotelId = hotelId; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public Integer getEstrellas() { return estrellas; }
    public void setEstrellas(Integer estrellas) { this.estrellas = estrellas; }
}