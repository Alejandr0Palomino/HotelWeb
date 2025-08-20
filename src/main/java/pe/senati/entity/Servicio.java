package pe.senati.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "servicios")
public class Servicio implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servicio_id")
    private Integer servicioId;
    
    @Column(length = 50, nullable = false)
    private String nombre;
    
    @Column(length = 200)
    private String descripcion;
    
    @ManyToMany(mappedBy = "servicios")
    private Set<Habitacion> habitaciones = new HashSet<>();
    
    public Servicio() {
    }

	public Servicio(Integer servicioId, String nombre, String descripcion, Set<Habitacion> habitaciones) {
		super();
		this.servicioId = servicioId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.habitaciones = habitaciones;
	}

	public Integer getServicioId() {
		return servicioId;
	}

	public void setServicioId(Integer servicioId) {
		this.servicioId = servicioId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Set<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

}