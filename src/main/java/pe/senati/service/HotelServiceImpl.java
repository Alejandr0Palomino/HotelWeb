package pe.senati.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.senati.entity.Hotel;
import pe.senati.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository repository;
    
    @Override
    @Transactional
    public void insert(Hotel hotel) {
        repository.save(hotel);
    }

    @Override
    @Transactional
    public void update(Hotel hotel) {
        repository.save(hotel);
    }

    @Override
    @Transactional
    public void delete(Integer hotelId) {
        repository.deleteById(hotelId);
    }

    @Override
    @Transactional(readOnly = true)
    public Hotel findById(Integer hotelId) {
        return repository.findById(hotelId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Hotel> findAll() {
        return repository.findAll();
    }

    @Override
    public Collection<Hotel> findByNombre(String nombre) {
        return repository.findByNombreContaining(nombre);
    }
}