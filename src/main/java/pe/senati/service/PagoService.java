package pe.senati.service;

import java.util.Collection;
import pe.senati.entity.Pago;

public interface PagoService {
    public abstract void insert(Pago pago);
    public abstract void update(Pago pago);
    public abstract void delete(Integer pagoId);
    public abstract Pago findById(Integer pagoId);
    public abstract Collection<Pago> findAll();
}