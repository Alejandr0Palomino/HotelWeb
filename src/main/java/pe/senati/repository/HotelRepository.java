package pe.senati.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.senati.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findByNombreContaining(String nombre);
}