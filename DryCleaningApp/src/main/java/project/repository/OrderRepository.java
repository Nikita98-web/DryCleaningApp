package project.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import project.jpa.IOrderJpa;
import project.models.Order;

public class OrderRepository implements IOrderRepository{
	@Autowired
	private IOrderJpa orderjpa;
	
	public Order addOrder(Order order) {
		orderjpa.save(order);
		return order;
	}
	
	public Order removeOrder(long id) {
		Order o=orderjpa.findById(id).get();
		orderjpa.delete(o);
		return o;
	}
	
	public Order updateOrder(long id, Order order) {
		Order o=orderjpa.findById(id).get();
		o.setOrderId(order.getOrderId());
		o.setAmount(order.getAmount());
		o.setBillingDate(order.getBillingDate());
		o.setBookingDetails(order.getBookingDetails());
		o.setCustomer(order.getCustomer());
		o.setPaymentMethod(order.getPaymentMethod());
		orderjpa.save(o);
		return o;
	}
	
	public Order getOrderDetails(long id) {
	    Order o=orderjpa.findById(id).get();
		return o;
	}
	
	public List<Order> getAllOrders(){
		List<Order> o = orderjpa.findAll();
		return o;
	}
}
