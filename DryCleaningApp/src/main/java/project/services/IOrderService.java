package project.services;
import java.util.List;

import project.models.*;

public interface IOrderService {
	Order addOrder(Order order);
	Order removeOrder(long id)throws Exception;
	Order updateOrder(long id, Order order)throws Exception;
	Order getOrderDetails(long id)throws Exception;
	List<Order> getAllOrders();
	List<Order> getOrderByCustomer(String id)throws Exception;
}
