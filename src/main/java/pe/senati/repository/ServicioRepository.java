package pe.senati.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.senati.entity.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    List<Servicio> findByNombreContaining(String nombre);
}