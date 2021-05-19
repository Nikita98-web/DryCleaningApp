package project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.models.Payment;
import project.repository.IPaymentRepository;
@Service
public class PaymentService implements IPaymentService{
	@Autowired
	private IPaymentRepository paymentRepository;
	
	public Payment addPayment(Payment payment) {
		return paymentRepository.addPayment(payment);	
	}
	
	public Payment removePayment(long id) throws Exception{
		return paymentRepository.removePayment(id);
	}
	
	public Payment updatePayment(long id, Payment payment)throws Exception {
		return paymentRepository.updatePayment(id, payment);
	}
	
	public Payment getPaymentDetails(long id) throws Exception{
		return paymentRepository.getPaymentDetails(id);
	}
	
	public List<Payment> getAllPaymentDetails(){
		return paymentRepository.getAllPaymentDetails();
	}
}
