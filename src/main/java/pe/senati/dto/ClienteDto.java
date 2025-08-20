package pe.senati.dto;

import java.util.List;

public class ClienteDto {
    private Integer clienteId;
    private String nombre;
    private String email;
    private String telefono;
    private List<Integer> reservaIds;

    public Integer getClienteId() { return clienteId; }
    public void setClienteId(Integer clienteId) { this.clienteId = clienteId; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public List<Integer> getReservaIds() { return reservaIds; }
    public void setReservaIds(List<Integer> reservaIds) { this.reservaIds = reservaIds; }
}