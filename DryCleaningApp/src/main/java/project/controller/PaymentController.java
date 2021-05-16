package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import project.models.Payment;
import project.services.IPaymentService;

@RestController
@RequestMapping("/Payment")
public class PaymentController {
	@Autowired
	private IPaymentService paymentService;
	
	@PostMapping("/add")
	public Payment addPayment(@RequestBody Payment payment) {
		return paymentService.addPayment(payment);	
	}
	
	@DeleteMapping("/remove/{id}")
	public Payment removePayment(@PathVariable long id) {
		return paymentService.removePayment(id);
	}
	
	@PutMapping("/update/{id}")
	public Payment updatePayment(@PathVariable long id,@RequestBody Payment payment) {
		return paymentService.updatePayment(id, payment);
	}
	
	@GetMapping("/get/{id}")
	public Payment getPaymentDetails(@PathVariable long id) {
		return paymentService.getPaymentDetails(id);
	}
	
	@GetMapping("/getbypayment")
	public List<Payment> getAllPaymentDetails(){
		return paymentService.getAllPaymentDetails();
	}
}
