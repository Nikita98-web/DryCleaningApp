package project.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import project.models.Payment;

public interface IPaymentJpa extends JpaRepository<Payment,Long> {
	List<Payment> findByCustomerId(String custId);
}
