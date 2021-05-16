package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public CustomerItem removeItem(@PathVariable long id) {
		return customerItemService.removeItem(id);
	}
	
	@PutMapping("/update/{id}")
	public CustomerItem updateItem(@PathVariable long id,@RequestBody CustomerItem item) {
		return customerItemService.updateItem(id, item);
	}
	
	@GetMapping("/get/{id}")
	public CustomerItem getItem(@PathVariable long id) {
		return customerItemService.getItem(id);
	}
	
	@GetMapping("/getbycustomer/{customerId}")
	public List<CustomerItem> getItemsByCustomer(@PathVariable long customerId){
		return customerItemService.getItemsByCustomer(customerId);
	}
}
