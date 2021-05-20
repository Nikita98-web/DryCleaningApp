package project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import project.exception.NotFoundException;
import project.models.Address;
import project.models.Booking;
import project.models.Card;
import project.models.Customer;
import project.models.Payment;
import project.services.IBookingService;
import project.services.IPaymentService;

@SpringBootTest
public class PaymentServiceTest {
	@Autowired
	private IPaymentService paymentService;
	
	
	Payment payment=null;
	Card card=null;
	
	@Test
	public void addPaymentTest01() {
		
		card=new Card(2,"MasterCard","1234567889567",LocalDate.parse("2026-09-06"),"SBI");
		payment=new Payment(4,"Online","Completed",card);
		assertNotNull (paymentService.addPayment(payment));
	}
	
	@Test
	public void removePaymentTest01() throws Exception{
		try {
			paymentService.removePayment(584);
		}
		catch(NotFoundException ex) {
		assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void updatePaymentTest01() throws Exception{
		card=new Card(2,"MasterCard","1234567889567",LocalDate.parse("2026-09-06"),"SBI");
		payment=new Payment(4,"Online","Completed",card);
		try {
			paymentService.updatePayment(364, payment);
		}
		catch(NotFoundException ex) {
			assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getPaymentTest01() throws Exception{
		try {
			paymentService.getPaymentDetails(356);
		}
		catch(NotFoundException ex) {
			assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getAllPaymentDetailsTest01() {
		assertNotNull (paymentService.getAllPaymentDetails());
	}
}
