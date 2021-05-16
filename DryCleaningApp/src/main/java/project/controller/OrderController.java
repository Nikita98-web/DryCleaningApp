package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Order removeOrder(@PathVariable long id) {
		return orderService.removeOrder(id);
	}
	
	@PutMapping("/update/{id}")
	public Order updateOrder(@PathVariable long id,@RequestBody Order order) {
		return orderService.updateOrder(id, order);
	}
	
	@GetMapping("/get/{id}")
	public Order getOrderDetails(@PathVariable long id) {
		return orderService.getOrderDetails(id);
	}
	
	@GetMapping("/getbyorder")
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}
}
