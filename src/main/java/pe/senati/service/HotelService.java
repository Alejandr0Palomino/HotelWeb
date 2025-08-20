package pe.senati.service;

import java.util.Collection;
import pe.senati.entity.Hotel;

public interface HotelService {
    public abstract void insert(Hotel hotel);
    public abstract void update(Hotel hotel);
    public abstract void delete(Integer hotelId);
    public abstract Hotel findById(Integer hotelId);
    public abstract Collection<Hotel> findAll();
    public abstract Collection<Hotel> findByNombre(String nombre);
}