package pe.senati.service;

import java.util.Collection;
import pe.senati.entity.Servicio;

public interface ServicioService {
    public abstract void insert(Servicio servicio);
    public abstract void update(Servicio servicio);
    public abstract void delete(Integer servicioId);
    public abstract Servicio findById(Integer servicioId);
    public abstract Collection<Servicio> findAll();
    public abstract Collection<Servicio> findByNombre(String nombre);
}