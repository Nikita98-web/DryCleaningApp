package project.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.jpa.IPaymentJpa;
import project.models.Payment;
@Repository
public class PaymentRepository implements IPaymentRepository {
	@Autowired
	private IPaymentJpa paymentjpa;
	
	public Payment addPayment(Payment payment) {
		paymentjpa.save(payment);
		return payment;
	}
	
	public Payment removePayment(long id) {
		Payment p = paymentjpa.findById(id).get();
		return p;
	}
	
	public Payment getPaymentDetails(long id) {
		Payment p=paymentjpa.findById(id).get();
		return p;
	}
	
	public List<Payment> getAllPaymentDetails(){
		List<Payment> p = paymentjpa.findAll();
		return p; 
	}
	
	public Payment updatePayment(long id, Payment payment) {
		Payment p = paymentjpa.findById(id).get();
		p.setPaymentId(payment.getPaymentId());
		p.setCard(payment.getCard());
		p.setStatus(payment.getStatus());
		p.setType(payment.getType());
		paymentjpa.save(p);
		return p;
	}
}
