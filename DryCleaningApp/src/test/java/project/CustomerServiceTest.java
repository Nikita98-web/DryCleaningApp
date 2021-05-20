package project;

import java.time.LocalDate;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import project.exception.*;

import project.models.*;
import project.services.ICustomerService;

@SpringBootTest
public class CustomerServiceTest {
	
	@Autowired
	private ICustomerService customerService;
	
	Address address=null;
	Customer customer=null;
	
	@BeforeAll
	public static void init() {
	}
	
	@Test
	public void addCustomerTest01() {
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		assertNotNull (customerService.addCustomer(customer));	
	}
	
	@Test
	public void removeCustomerTest01() throws NotFoundException{
		try {
			customerService.removeCustomer(456);
		}
		catch(NotFoundException ex) {
		assertEquals("Customer id not found",ex.getMessage());
		}
		
	}
	
	
	@Test
	public void updateCustomerTest01() throws NotFoundException{
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		try {
			customerService.updateCustomer(234, customer);
		}
		catch(NotFoundException ex) {
			assertEquals("User Id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getCustomerTest01() throws Exception{
		try {
			customerService.getCustomer(345);
		}
		catch(NotFoundException ex) {
			assertEquals("Customer id is not present",ex.getMessage());
		}
	}
	
	@Test
	public void getAllCustomersTest01() {
		assertNotNull (customerService.getAllCustomers());
	}
	
	
}
