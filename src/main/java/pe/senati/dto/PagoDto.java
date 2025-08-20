package pe.senati.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PagoDto {
    private Integer pagoId;
    private BigDecimal monto;
    private String metodoPago;
    private Integer reservaId;
    private LocalDate fechaReserva;

    // Getters y Setters
    public Integer getPagoId() { return pagoId; }
    public void setPagoId(Integer pagoId) { this.pagoId = pagoId; }
    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }
    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
    public Integer getReservaId() { return reservaId; }
    public void setReservaId(Integer reservaId) { this.reservaId = reservaId; }
    public LocalDate getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(LocalDate fechaReserva) { this.fechaReserva = fechaReserva; }
}