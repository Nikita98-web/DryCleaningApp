package project;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import project.controller.PaymentController;
import project.exception.NotFoundException;
import project.models.Card;
import project.models.Order;
import project.models.Payment;
import project.services.IPaymentService;

@SpringBootTest
public class PaymentControllerTest {
	static final Logger LOGGER = LoggerFactory.getLogger(PaymentControllerTest.class);
	@Autowired
	private PaymentController paymentController;
	
	
	Payment payment=null;
	Card card=null;
	
	@Test
	public void addPaymentTest01() {
		LOGGER.info("addPaymentTest01 method executed");
		card=new Card(2,"MasterCard","1234567889567",LocalDate.parse("2026-09-06"),"SBI");
		payment=new Payment(4,"Online","Completed",card);
		assertEquals (paymentController.addPayment(payment).getStatusCode(),HttpStatus.CREATED);
	}
	
	@Test
	public void updatePaymentTest01() throws Exception {
		LOGGER.info("updatePaymentTest01 method executed");
		card=new Card(2,"MasterCard","1234567889567",LocalDate.parse("2026-09-06"),"SBI");
		payment=new Payment(4,"Online","Completed",card);
		try {
		assertEquals (paymentController.updatePayment(4, payment).getStatusCode(),HttpStatus.OK);
		}
		catch(NotFoundException ex) {
			assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getPaymentTest01() throws Exception {
		LOGGER.info("getPaymentTest01 method executed");
		try {
		assertEquals (paymentController.getPaymentDetails(4).getStatusCode(),HttpStatus.OK);
		}
		catch(NotFoundException ex) {
			assertEquals("Payment id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getAllPaymentDetailsTest01()  {
		LOGGER.info("getAllPaymentDetailsTest01 method executed");
		assertEquals (paymentController.getAllPaymentDetails().getStatusCode(),HttpStatus.OK);
	}
}
