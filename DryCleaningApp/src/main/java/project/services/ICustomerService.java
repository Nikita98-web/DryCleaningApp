package project.services;
import java.util.List;

import project.models.*;

public interface ICustomerService {
	Customer addCustomer(Customer customer);
	Customer removeCustomer(long custId);
	Customer updateCustomer(long custId, Customer customer);
	Customer getCustomer(long custId);
	List<Customer> getAllCustomers();
}
