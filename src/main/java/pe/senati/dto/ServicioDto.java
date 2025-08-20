package pe.senati.dto;

import java.util.List;
import java.util.stream.Collectors;

import pe.senati.entity.Habitacion;
import pe.senati.entity.Servicio;

public class ServicioDto {
    private Integer servicioId;
    private String nombre;
    private String descripcion;
    private List<Integer> habitacionIds;


    public ServicioDto(Servicio servicio) {
        this.servicioId = servicio.getServicioId();
        this.nombre = servicio.getNombre();
        this.descripcion = servicio.getDescripcion();
        this.habitacionIds = servicio.getHabitaciones().stream()
            .map(Habitacion::getHabitacionId)
            .collect(Collectors.toList());
    }


	public Integer getServicioId() {
		return servicioId;
	}


	public String getNombre() {
		return nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public List<Integer> getHabitacionIds() {
		return habitacionIds;
	}
    
    
}