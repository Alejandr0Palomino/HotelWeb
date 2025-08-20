package pe.senati.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.senati.entity.Pago;
import pe.senati.repository.PagoRepository;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoRepository repository;
    
    @Override
    @Transactional
    public void insert(Pago pago) {
        repository.save(pago);
    }

    @Override
    @Transactional
    public void update(Pago pago) {
        repository.save(pago);
    }

    @Override
    @Transactional
    public void delete(Integer pagoId) {
        repository.deleteById(pagoId);
    }

    @Override
    @Transactional(readOnly = true)
    public Pago findById(Integer pagoId) {
        return repository.findById(pagoId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Pago> findAll() {
        return repository.findAll();
    }
}