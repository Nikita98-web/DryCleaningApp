package project.services;
import java.util.List;

import project.models.*;

public interface IPaymentService {
	Payment addPayment(Payment payment);
	Payment removePayment(long id);
	Payment updatePayment(long id, Payment payment);
	Payment getPaymentDetails(long id);
	List<Payment> getAllPaymentDetails();
}
