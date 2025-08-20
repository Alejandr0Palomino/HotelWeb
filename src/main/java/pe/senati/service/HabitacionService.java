package pe.senati.service;

import java.util.Collection;
import pe.senati.entity.Habitacion;

public interface HabitacionService {
    public abstract void insert(Habitacion habitacion);
    public abstract void update(Habitacion habitacion);
    public abstract void delete(Integer habitacionId);
    public abstract Habitacion findById(Integer habitacionId);
    public abstract Collection<Habitacion> findAll();
    public abstract Habitacion findByNumero(String numero);
}