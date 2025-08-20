package pe.senati.dto;

import java.time.LocalDate;
import java.math.BigDecimal;

public class ReservaDto {
    private Integer reservaId;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Integer clienteId;
    private String clienteNombre;
    private Integer habitacionId;
    private String habitacionNumero;
    private Integer pagoId;
    private BigDecimal pagoMonto;
    private String metodoPago;

    // Getters y Setters
    public Integer getReservaId() { return reservaId; }
    public void setReservaId(Integer reservaId) { this.reservaId = reservaId; }
    public LocalDate getFechaEntrada() { return fechaEntrada; }
    public void setFechaEntrada(LocalDate fechaEntrada) { this.fechaEntrada = fechaEntrada; }
    public LocalDate getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(LocalDate fechaSalida) { this.fechaSalida = fechaSalida; }
    public Integer getClienteId() { return clienteId; }
    public void setClienteId(Integer clienteId) { this.clienteId = clienteId; }
    public String getClienteNombre() { return clienteNombre; }
    public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }
    public Integer getHabitacionId() { return habitacionId; }
    public void setHabitacionId(Integer habitacionId) { this.habitacionId = habitacionId; }
    public String getHabitacionNumero() { return habitacionNumero; }
    public void setHabitacionNumero(String habitacionNumero) { this.habitacionNumero = habitacionNumero; }
    public Integer getPagoId() { return pagoId; }
    public void setPagoId(Integer pagoId) { this.pagoId = pagoId; }
    public BigDecimal getPagoMonto() { return pagoMonto; }
    public void setPagoMonto(BigDecimal pagoMonto) { this.pagoMonto = pagoMonto; }
    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
}