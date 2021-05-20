package project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import project.exception.NotFoundException;
import project.models.Address;
import project.models.Booking;
import project.models.Customer;
import project.models.Order;
import project.services.IBookingService;
import project.services.IOrderService;



@SpringBootTest
public class OrderServiceTest {
	
	@Autowired
	private IOrderService orderService;
	
	Address address=null;
	Customer customer=null;
	Booking booking=null;
	Order order=null;
	
	@Test
	public void addOrderTest01() {
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customer);
		order=new Order(1,5000.00,LocalDate.parse("2021-05-03"),customer,"Online",booking);
		assertNotNull (orderService.addOrder(order));
	}
	
	@Test
	public void removeOrderTest01() throws Exception{
		try {
			orderService.removeOrder(586);
		}
		catch(NotFoundException ex) {
		assertEquals("Order id is not valid",ex.getMessage());
		}		
	}
	
	@Test
	public void updateOrderTest01() throws Exception{
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customer);
		order=new Order(1,5000.00,LocalDate.parse("2021-05-03"),customer,"Online",booking);
		try {
			orderService.updateOrder(457, order);
		}
		catch(NotFoundException ex) {
			assertEquals("Order id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getOrderTest01() throws Exception{
		try {
			orderService.getOrderDetails(438);
		}
		catch(NotFoundException ex) {
			assertEquals("Order id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getAllordersTest01() {
		assertNotNull (orderService.getAllOrders());
	}
}
