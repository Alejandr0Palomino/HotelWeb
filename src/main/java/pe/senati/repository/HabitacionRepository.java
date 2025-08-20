package pe.senati.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.senati.entity.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
    Habitacion findByNumero(String numero);
}