package project.services;
import java.util.List;

import project.exception.NotFoundException;
import project.models.*;

public interface ICustomerService {
	Customer addCustomer(Customer customer);
	Customer removeCustomer(long custId)throws NotFoundException;
	Customer updateCustomer(long custId, Customer customer)throws NotFoundException;
	Customer getCustomer(long custId)throws Exception;
	List<Customer> getAllCustomers();
}
