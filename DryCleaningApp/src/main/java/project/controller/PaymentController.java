package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Object> removePayment(@PathVariable long id) throws Exception {
		ResponseEntity<Object> response=null;
		Payment p= paymentService.removePayment(id);
		response = new ResponseEntity<Object>(p,HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updatePayment(@PathVariable long id,@RequestBody Payment payment) throws Exception {
		ResponseEntity<Object> response=null;
		Payment p= paymentService.updatePayment(id, payment);
		response = new ResponseEntity<Object>(p,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getPaymentDetails(@PathVariable long id)throws Exception {
		ResponseEntity<Object> response=null;
		Payment p= paymentService.getPaymentDetails(id);
		response = new ResponseEntity<Object>(p,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/get")
	public List<Payment> getAllPaymentDetails(){
		return paymentService.getAllPaymentDetails();
	}
}
