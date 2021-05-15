package project.repository;

import java.util.List;

import project.models.CustomerItem;

public interface ICustomerItemRepository {
	CustomerItem addItem(CustomerItem item);
	CustomerItem removeItem(long id);
	CustomerItem updateItem(long id, CustomerItem item);
	CustomerItem getItem(long id);
	List<CustomerItem> getItemsByCustomer(long customerId);
}
