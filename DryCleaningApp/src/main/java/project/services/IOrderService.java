package project.services;
import java.util.List;

import project.models.*;

public interface IOrderService {
	Order addOrder(Order order);
	Order removeOrder(long id);
	Order updateOrder(long id, Order order);
	Order getOrderDetails(long id);
	List<Order> getAllOrders();
}
