package project.repository;

import java.util.List;

import project.exception.NotFoundException;
import project.models.CustomerItem;

public interface ICustomerItemRepository {
	CustomerItem addItem(CustomerItem item);
	CustomerItem removeItem(long id)throws Exception;
	CustomerItem updateItem(long id, CustomerItem item)throws Exception;
	CustomerItem getItem(long id)throws Exception;
	List<CustomerItem> getItemsByCustomer(long customerId)throws Exception;
}
