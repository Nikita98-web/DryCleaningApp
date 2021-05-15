package project.repository;

import java.util.List;

import project.models.Payment;

public interface IPaymentRepository {
	Payment addPayment(Payment payment);
	Payment removePayment(long id);
	Payment updatePayment(long id, Payment payment);
	Payment getPaymentDetails(long id);
	List<Payment> getAllPaymentDetails();
}
