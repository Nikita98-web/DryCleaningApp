package project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.models.Order;
import project.repository.IOrderRepository;
@Service
public class OrderService implements IOrderService{
	@Autowired
	private IOrderRepository orderRepository;
	
	public Order addOrder(Order order) {
		return orderRepository.addOrder(order);
	}
	
	public Order removeOrder(long id) throws Exception{
		return orderRepository.removeOrder(id);
	}
	
	public Order updateOrder(long id, Order order)throws Exception {
		return orderRepository.updateOrder(id, order);
	}
	
	public Order getOrderDetails(long id)throws Exception {
		return orderRepository.getOrderDetails(id);
	}
	
	public List<Order> getAllOrders(){
		return orderRepository.getAllOrders();
	}
}
