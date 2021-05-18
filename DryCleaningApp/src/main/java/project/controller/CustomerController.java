package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import project.exception.NotFoundException;
import project.models.Customer;
import project.services.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	
	@PostMapping("/add")
	Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@DeleteMapping("/remove/{custId}")
	public ResponseEntity<Object> removeCustomer(@PathVariable long custId) throws NotFoundException{
		ResponseEntity <Object>response=null;
		Customer c = customerService.removeCustomer(custId);
		response=new ResponseEntity<Object>(c,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/update/{custId}")
	public ResponseEntity <Object> updateCustomer(@PathVariable long custId,@RequestBody Customer customer)throws NotFoundException {
		ResponseEntity <Object>response=null;
		
			Customer c = customerService.updateCustomer(custId, customer);
			response=new ResponseEntity<>(c, HttpStatus.ACCEPTED);
			return response;
	}
	
	@GetMapping("/get/{custId}")
	public ResponseEntity <Object> getCustomer(@PathVariable long custId)throws Exception {
		ResponseEntity <Object>response=null;
		Customer c= customerService.getCustomer(custId);
		response=new ResponseEntity<>(c, HttpStatus.ACCEPTED);		
		return response;
	}
	
	@GetMapping("/get")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
}
