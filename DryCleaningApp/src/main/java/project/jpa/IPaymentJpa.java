package project.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import project.models.Payment;

public interface IPaymentJpa extends JpaRepository<Payment,Long> {
	
}
