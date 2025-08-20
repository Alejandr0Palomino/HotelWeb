package pe.senati.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.senati.entity.Reserva;
import pe.senati.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository repository;
    
    @Override
    @Transactional
    public void insert(Reserva reserva) {
        repository.save(reserva);
    }

    @Override
    @Transactional
    public void update(Reserva reserva) {
        repository.save(reserva);
    }

    @Override
    @Transactional
    public void delete(Integer reservaId) {
        repository.deleteById(reservaId);
    }

    @Override
    @Transactional(readOnly = true)
    public Reserva findById(Integer reservaId) {
        return repository.findById(reservaId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Reserva> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Reserva> findByClienteId(Integer clienteId) {
        return repository.findByClienteClienteId(clienteId);
    }
}