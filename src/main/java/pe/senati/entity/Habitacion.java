package pe.senati.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "habitaciones")
public class Habitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habitacion_id")
    private Integer habitacionId;
    
    @Column(length = 10, nullable = false, unique = true)
    private String numero;
    
    @Column(length = 30, nullable = false)
    private String tipo;
    
    @Column(nullable = false)
    private BigDecimal precio;
    
    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;
    
    @ManyToMany
    @JoinTable(
        name = "habitacion_servicio",
        joinColumns = @JoinColumn(name = "habitacion_id"),
        inverseJoinColumns = @JoinColumn(name = "servicio_id")
    )
    private Set<Servicio> servicios = new HashSet<>();
    
    // Constructores
    public Habitacion() {
    }

	public Habitacion(Integer habitacionId, String numero, String tipo, BigDecimal precio, Hotel hotel,
			Set<Servicio> servicios) {
		super();
		this.habitacionId = habitacionId;
		this.numero = numero;
		this.tipo = tipo;
		this.precio = precio;
		this.hotel = hotel;
		this.servicios = servicios;
	}

	public Integer getHabitacionId() {
		return habitacionId;
	}

	public void setHabitacionId(Integer habitacionId) {
		this.habitacionId = habitacionId;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Set<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(Set<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	
	public void agregarServicio(Servicio servicio) {
        this.servicios.add(servicio);
        servicio.getHabitaciones().add(this);
    }
	
	public void quitarServicio(Servicio servicio) {
        this.servicios.remove(servicio);
        servicio.getHabitaciones().remove(this);
    }
}