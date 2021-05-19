package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import project.models.Order;
import project.services.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	
	@PostMapping("/add")
	public Order addOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> removeOrder(@PathVariable long id)throws Exception {
		ResponseEntity<Object> response=null;
		Order o= orderService.removeOrder(id);
		response = new ResponseEntity<Object>(o,HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateOrder(@PathVariable long id,@RequestBody Order order)throws Exception {
		ResponseEntity<Object> response=null;
		Order o= orderService.updateOrder(id, order);
		response = new ResponseEntity<Object>(o,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getOrderDetails(@PathVariable long id) throws Exception{
		ResponseEntity<Object> response=null;
		Order o =  orderService.getOrderDetails(id);
		response = new ResponseEntity<Object>(o,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/get")
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}
}
