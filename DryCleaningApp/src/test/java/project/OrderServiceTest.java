package project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import project.exception.NotFoundException;
import project.models.Address;
import project.models.Booking;
import project.models.Customer;
import project.models.CustomerItem;
import project.models.Order;
import project.services.IBookingService;
import project.services.IOrderService;



@SpringBootTest
public class OrderServiceTest {
	static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceTest.class);
	@Autowired
	private IOrderService orderService;
	
	Address address=null;
	Customer customer=null;
	Booking booking=null;
	Order order=null;
	CustomerItem customerItem=null;
	
	@Test
	public void addOrderTest01() {
		LOGGER.info("addOrderTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customerItem);
		order=new Order(2,5000.00,LocalDate.parse("2021-05-03"),customer,"Online",booking);
		assertNotNull (orderService.addOrder(order));
	}
	
	@Test
	public void removeOrderTest01() throws Exception{
		LOGGER.info("removeOrderTest01 method executed");
		try {
			orderService.removeOrder(586);
		}
		catch(NotFoundException ex) {
		assertEquals("Order id is not valid",ex.getMessage());
		}		
	}
	@Test
	public void removeOrderTest02() throws Exception{
		LOGGER.info("removeOrderTest02 method executed");
		try {
			orderService.removeOrder(200);
		}
		catch(NotFoundException ex) {
		assertEquals("Order id is not valid",ex.getMessage());
		}		
	}
	
	
	@Test
	public void updateOrderTest01() throws Exception{
		LOGGER.info("updateOrderTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customerItem);
		order=new Order(1,5000.00,LocalDate.parse("2021-05-03"),customer,"Online",booking);
		try {
			orderService.updateOrder(457, order);
		}
		catch(NotFoundException ex) {
			assertEquals("Order id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void updateOrderTest02() throws Exception{
		LOGGER.info("updateOrderTest02 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
		booking=new Booking(15,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customerItem);
		order=new Order(2,5000.00,LocalDate.parse("2021-05-03"),customer,"Online",booking);
		try {
		assertNotNull(orderService.updateOrder(2, order));
		}
		catch(NotFoundException ex) {
			assertEquals("Order id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getOrderTest01() throws Exception{
		LOGGER.info("getOrderTest01 method executed");
		try {
			orderService.getOrderDetails(438);
		}
		catch(NotFoundException ex) {
			assertEquals("Order id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getOrderTest02() throws Exception{
		LOGGER.info("getOrderTest02 method executed");
		try {
		assertNotNull(orderService.getOrderDetails(2));
		}
		catch(NotFoundException ex) {
			assertEquals("Order id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getAllordersTest01() {
		LOGGER.info("getAllorders Test01 method executed");
		assertNotNull (orderService.getAllOrders());
	}
}
