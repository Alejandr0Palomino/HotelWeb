package pe.senati.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.senati.entity.Habitacion;
import pe.senati.repository.HabitacionRepository;

@Service
public class HabitacionServiceImpl implements HabitacionService {

    @Autowired
    private HabitacionRepository repository;
    
    @Override
    @Transactional
    public void insert(Habitacion habitacion) {
        repository.save(habitacion);
    }

    @Override
    @Transactional
    public void update(Habitacion habitacion) {
        repository.save(habitacion);
    }

    @Override
    @Transactional
    public void delete(Integer habitacionId) {
        repository.deleteById(habitacionId);
    }

    @Override
    @Transactional(readOnly = true)
    public Habitacion findById(Integer habitacionId) {
        return repository.findById(habitacionId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Habitacion> findAll() {
        return repository.findAll();
    }

    @Override
    public Habitacion findByNumero(String numero) {
        return repository.findByNumero(numero);
    }
}