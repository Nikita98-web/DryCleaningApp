package project.repository;

import java.util.List;

import project.models.Payment;

public interface IPaymentRepository {
	Payment addPayment(Payment payment);
	Payment removePayment(long id)throws Exception;
	Payment updatePayment(long id, Payment payment)throws Exception;
	Payment getPaymentDetails(long id)throws Exception;
	List<Payment> getAllPaymentDetails();
	List<Payment> getCustomerPaymentDetails(String custId) throws Exception;
}
