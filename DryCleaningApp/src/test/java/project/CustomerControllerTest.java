package project;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import project.controller.CustomerController;
import project.exception.NotFoundException;
import project.models.Address;
import project.models.Customer;
import project.services.ICustomerService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CustomerControllerTest {
	static final Logger LOGGER = LoggerFactory.getLogger(CustomerControllerTest.class);
	@Autowired
	private CustomerController customerController;
	
	Address address=null;
	Customer customer=null;
	
	@BeforeAll
	public static void init() {
	}
	
	@Test
	public void addCustomerTest01() {
		LOGGER.info("addCustomerTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("7","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		assertEquals(customerController.addCustomer(customer).getStatusCode(), HttpStatus.CREATED);
	}

	@Test
	public void updateCustomerTest01() throws NotFoundException{
		LOGGER.info("updateCustomerTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("7","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		try {
		assertEquals(customerController.updateCustomer("6", customer).getStatusCode(), HttpStatus.ACCEPTED);
		}
		catch(NotFoundException ex) {
			assertEquals("User Id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getCustomerTest01() throws Exception{
		LOGGER.info("getCustomerTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("7","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		try {
		assertEquals(customerController.getCustomer("7").getStatusCode(), HttpStatus.ACCEPTED);
		}
		catch(NotFoundException ex) {
			assertEquals("Customer id is not present",ex.getMessage());
		}
	}
	
	@Test
	public void getAllCustomerTest01() {
		LOGGER.info("getAllCustomerTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("7","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		assertEquals(customerController.getAllCustomers().getStatusCode(), HttpStatus.OK);
	}
	
}
