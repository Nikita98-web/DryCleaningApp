package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import project.models.CustomerItem;
import project.services.ICustomerItemService;

@RestController
@RequestMapping("/customeritem")
public class CustomerItemController {
	@Autowired
	private ICustomerItemService customerItemService;
	
	@PostMapping("/add")
	public CustomerItem addItem(@RequestBody CustomerItem item) {
		return customerItemService.addItem(item);
	}
	
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> removeItem(@PathVariable long id)throws Exception {
		ResponseEntity<Object> response = null;
		CustomerItem ci= customerItemService.removeItem(id);
		response = new ResponseEntity<Object>(ci, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateItem(@PathVariable long id,@RequestBody CustomerItem item) throws Exception{
		ResponseEntity<Object> response = null;
		CustomerItem ci=customerItemService.updateItem(id, item);
		response = new ResponseEntity<Object>(ci, HttpStatus.ACCEPTED);
		return response;
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getItem(@PathVariable long id) throws Exception{
		ResponseEntity<Object> response = null;
		CustomerItem ci= customerItemService.getItem(id);
		response = new ResponseEntity<Object>(ci, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getbycustomer/{customerId}")
	public ResponseEntity<Object> getItemsByCustomer(@PathVariable long customerId)throws Exception{
		ResponseEntity<Object> response = null;
		List<CustomerItem> ci= customerItemService.getItemsByCustomer(customerId);
		response = new ResponseEntity<Object>(ci, HttpStatus.OK);
		return response;
	}
}
