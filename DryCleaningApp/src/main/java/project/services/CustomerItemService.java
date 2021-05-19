package project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.models.CustomerItem;
import project.repository.ICustomerItemRepository;
@Service
public class CustomerItemService implements ICustomerItemService {
	@Autowired
	private ICustomerItemRepository customerItemRepository;
	
	public CustomerItem addItem(CustomerItem item) {
		return customerItemRepository.addItem(item);
	}
	
	public CustomerItem removeItem(long id) throws Exception{
		return customerItemRepository.removeItem(id);
	}
	
	public CustomerItem updateItem(long id, CustomerItem item)throws Exception {
		return customerItemRepository.updateItem(id, item);
	}
	
	public CustomerItem getItem(long id) throws Exception{
		return customerItemRepository.getItem(id);
	}
	
	public List<CustomerItem> getItemsByCustomer(long customerId)throws Exception{
		return customerItemRepository.getItemsByCustomer(customerId);
	}
}
