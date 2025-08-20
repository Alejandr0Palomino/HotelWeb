package pe.senati.service;

import java.util.Collection;
import pe.senati.entity.Reserva;

public interface ReservaService {
    public abstract void insert(Reserva reserva);
    public abstract void update(Reserva reserva);
    public abstract void delete(Integer reservaId);
    public abstract Reserva findById(Integer reservaId);
    public abstract Collection<Reserva> findAll();
    public abstract Collection<Reserva> findByClienteId(Integer clienteId);
}