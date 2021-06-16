package project.services;
import java.util.List;

import project.exception.NotFoundException;
import project.models.*;

public interface ICustomerService {
	Customer addCustomer(Customer customer);
	Customer removeCustomer(String custId)throws NotFoundException;
	Customer updateCustomer(String custId, Customer customer)throws NotFoundException;
	Customer getCustomer(String custId)throws Exception;
	List<Customer> getAllCustomers();
}
