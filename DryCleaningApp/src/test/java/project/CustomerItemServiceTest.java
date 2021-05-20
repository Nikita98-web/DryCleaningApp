package project;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import project.exception.NotFoundException;
import project.models.Address;
import project.models.Booking;
import project.models.Customer;
import project.models.CustomerItem;
import project.services.*;

@SpringBootTest
public class CustomerItemServiceTest {
	@Autowired
	private ICustomerItemService customerItemService;
	
	CustomerItem customerItem=null;
	Address address=null;
	Customer customer=null;
	
	@Test
	public void removeItemTest01() throws Exception{
		try {
			customerItemService.removeItem(746);
		}
		catch(NotFoundException ex) {
		assertEquals("Customer item is not valid",ex.getMessage());
		}
	}
	
		@Test
		public void getItemTest01() throws Exception{
			try {
				customerItemService.getItem(987);
			}
			catch(NotFoundException ex) {
				assertEquals("CustomerItem is not valid",ex.getMessage());
			}
		}
		
		@Test
		public void getBookingsByCustomerTest01() throws Exception {
			try {
			      customerItemService.getItemsByCustomer(789);
			}
			catch(NotFoundException ex) {
				assertEquals("Customerid is not valid",ex.getMessage());
			}	
		}
		
		@Test
		public void updateCustomerItemTest01() throws Exception{
			address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
			customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
			customerItem=new CustomerItem(1,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
			try {
				customerItemService.updateItem(658, customerItem);
			}
			catch(NotFoundException ex) {
				assertEquals("CustomerItem is not valid",ex.getMessage());
			}
		}
		
		@Test
		public void addItemTest01() {
			address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
			customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
			customerItem=new CustomerItem(1,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
			assertNotNull (customerItemService.addItem(customerItem));
		}
		
		
		
	}

	
