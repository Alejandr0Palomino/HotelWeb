package pe.senati.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.senati.entity.Reserva;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    List<Reserva> findByClienteClienteId(Integer clienteId);
}