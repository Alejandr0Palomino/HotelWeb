package pe.senati.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.senati.entity.Pago;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
	
}