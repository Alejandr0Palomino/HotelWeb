package pe.senati.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.senati.entity.Servicio;
import pe.senati.repository.ServicioRepository;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository repository;
    
    @Override
    @Transactional
    public void insert(Servicio servicio) {
        repository.save(servicio);
    }

    @Override
    @Transactional
    public void update(Servicio servicio) {
        repository.save(servicio);
    }

    @Override
    @Transactional
    public void delete(Integer servicioId) {
        repository.deleteById(servicioId);
    }

    @Override
    @Transactional(readOnly = true)
    public Servicio findById(Integer servicioId) {
        return repository.findById(servicioId).orElse(null);
    }

    @Override
    public Collection<Servicio> findAll() {
        return repository.findAll();
    }

    @Override
    public Collection<Servicio> findByNombre(String nombre) {
        return repository.findByNombreContaining(nombre);
    }
    
}