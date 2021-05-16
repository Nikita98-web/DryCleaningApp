package project.repository;

import project.models.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.jpa.*;
@Repository
public class CustomerRepository  implements ICustomerRepository{
	@Autowired
	private ICustomerJpa customerjpa;
	
	public Customer addCustomer(Customer customer) {
		customerjpa.save(customer);
		return customer;
	}
	
	public Customer removeCustomer(long custId) {
		Customer c = customerjpa.findById(Long.toString(custId)).get();
		customerjpa.delete(c);
		return c;	
	}
	
	public Customer updateCustomer(long custId, Customer customer) {
		Customer c = customerjpa.findById(Long.toString(custId)).get();
		c.setUserId(customer.getUserId());
		c.setName(customer.getName());
		c.setAddress(customer.getAddress());
		c.setEmail(customer.getEmail());
		c.setDob(customer.getDob());
		c.setContactNo(customer.getContactNo());
		customerjpa.save(c);
		return c;
	}
	
	public Customer getCustomer(long custId) {
		Customer c = customerjpa.findById(Long.toString(custId)).get();
		return c;
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer> listCustomer = customerjpa.findAll();
		return listCustomer;
	}
	
}
