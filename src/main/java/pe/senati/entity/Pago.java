package pe.senati.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "pagos")
public class Pago implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pago_id")
    private Integer pagoId;
    
    @Column(nullable = false)
    private BigDecimal monto;
    
    @Column(name = "metodo_pago", length = 30, nullable = false)
    private String metodoPago;
    
    @OneToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reserva reserva;
    
    public Pago() {
    }

    public Pago(BigDecimal monto, String metodoPago) {
        this.monto = monto;
        this.metodoPago = metodoPago;
    }

    // Getters y Setters
    public Integer getPagoId() {
        return pagoId;
    }

    public void setPagoId(Integer pagoId) {
        this.pagoId = pagoId;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}