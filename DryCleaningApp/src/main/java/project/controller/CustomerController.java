package project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import project.exception.NotFoundException;
import project.models.Customer;
import project.services.ICustomerService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private ICustomerService customerService;
	
	//Add Custommer
	@PostMapping("/add")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
		ResponseEntity<Object> response=null;
		LOGGER.info("/customer/add URL is opened");
		LOGGER.info("addCustomer method executed");
		Customer c= customerService.addCustomer(customer);
		response=new ResponseEntity<Object>(c,HttpStatus.CREATED);
		return response;
	}
	
	//Remove customer by customerId
	@DeleteMapping("/remove/{custId}")
	public ResponseEntity<Object> removeCustomer(@PathVariable String custId) throws NotFoundException{
		LOGGER.info("/customer/remove/{custId} URL is opened");
		LOGGER.info("Remove Customer method executed");
		ResponseEntity <Object>response=null;
		Customer c = customerService.removeCustomer(custId);
		response=new ResponseEntity<Object>(c,HttpStatus.OK);
		return response;
	}
	
	//Update Customer by CustomerId
	@PutMapping("/update/{custId}")
	public ResponseEntity <Object> updateCustomer(@PathVariable String custId,@RequestBody Customer customer)throws NotFoundException {
		LOGGER.info("/customer/update/{custId} URL is opened");
		LOGGER.info("Update Customer method executed");
		ResponseEntity <Object>response=null;
		
			Customer c = customerService.updateCustomer(custId, customer);
			response=new ResponseEntity<>(c, HttpStatus.ACCEPTED);
			return response;
	}
	
	//Get customer by customerId
	@GetMapping("/get/{custId}")
	public ResponseEntity <Object> getCustomer(@PathVariable String custId)throws Exception {
		LOGGER.info("/customer/get/{custId} URL is opened");
		LOGGER.info("Get Customer method executed");
		ResponseEntity <Object>response=null;
		Customer c= customerService.getCustomer(custId);
		response=new ResponseEntity<>(c, HttpStatus.ACCEPTED);		
		return response;
	}
	
	//Get all customers
	@GetMapping("/get")
	public ResponseEntity <Object> getAllCustomers(){
		ResponseEntity <Object> response=null;
		LOGGER.info("/customer/get URL is opened");
		LOGGER.info("GetAll Customer method executed");
		List<Customer> lc= customerService.getAllCustomers();
		response=new ResponseEntity <Object>(lc,HttpStatus.OK);
		return response;
	}
	
}
