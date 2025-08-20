package pe.senati.entity;

import java.io.Serializable;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "reservas")
public class Reserva implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserva_id")
    private Integer reservaId;
    
    @Column(name = "fecha_entrada", nullable = false)
    private String fechaEntrada; 
    
    @Column(name = "fecha_salida", nullable = false)
    private String fechaSalida;   
    
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "habitacion_id", nullable = false)
    private Habitacion habitacion;
    
    @OneToOne(mappedBy = "reserva", cascade = CascadeType.ALL)
    private Pago pago;
    
    public Reserva() {
    }

	public Reserva(Integer reservaId, String fechaEntrada, String fechaSalida, Cliente cliente, Habitacion habitacion,
			Pago pago) {
		super();
		this.reservaId = reservaId;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.cliente = cliente;
		this.habitacion = habitacion;
		this.pago = pago;
	}



	public Integer getReservaId() {
		return reservaId;
	}

	public void setReservaId(Integer reservaId) {
		this.reservaId = reservaId;
	}

	public String getFechaEntrada() {
        return fechaEntrada;
    }

	public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

	public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}
}