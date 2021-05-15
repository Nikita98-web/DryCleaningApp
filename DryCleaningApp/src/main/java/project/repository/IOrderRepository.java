package project.repository;

import java.util.List;

import project.models.Order;

public interface IOrderRepository {
	Order addOrder(Order order);
	Order removeOrder(long id);
	Order updateOrder(long id, Order order);
	Order getOrderDetails(long id);
	List<Order> getAllOrders();
}
