package project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.exception.NotFoundException;
import project.models.Customer;
import project.repository.ICustomerRepository;
@Service
public class CustomService implements ICustomerService {
	@Autowired
	private ICustomerRepository customerRepository;
	
	public Customer addCustomer(Customer customer) {
		return customerRepository.addCustomer(customer);
	}
	
	public Customer removeCustomer(long custId)throws NotFoundException{
		return customerRepository.removeCustomer(custId);
	}
	
	public Customer updateCustomer(long custId, Customer customer) throws NotFoundException {
		return customerRepository.updateCustomer(custId, customer);
	}
	
	public Customer getCustomer(long custId)throws Exception {
		return customerRepository.getCustomer(custId);
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepository.getAllCustomers();
	}
}
