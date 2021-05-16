package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

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
	public Customer removeCustomer(@PathVariable long custId) {
		return customerService.removeCustomer(custId);
	}
	
	@PostMapping("/update/{custId}")
	public Customer updateCustomer(@PathVariable long custId,@RequestBody Customer customer) {
		return customerService.updateCustomer(custId, customer);
	}
	
	@GetMapping("/get/{custId}")
	public Customer getCustomer(@PathVariable long custId) {
		return customerService.getCustomer(custId);
	}
	
	@GetMapping("/get")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
}
