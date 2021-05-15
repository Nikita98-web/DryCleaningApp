package project.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import project.models.Customer;

public interface ICustomerRepository{
	Customer addCustomer(Customer customer);
	Customer removeCustomer(long custId);
	Customer updateCustomer(long custId, Customer customer);
	Customer getCustomer(long custId);
	List<Customer> getAllCustomers();
}
