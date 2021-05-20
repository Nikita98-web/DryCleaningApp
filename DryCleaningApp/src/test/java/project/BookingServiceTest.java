package project;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import static org.hamcrest.MatcherAssert.*;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.*;
import project.exception.*;

import project.models.*;
import project.services.*;

@SpringBootTest
public class BookingServiceTest {


	@Autowired
	private IBookingService bookingService;
	
	Address address=null;
	Customer customer=null;
	Booking booking=null;
	
	@Test
	public void addBookingTest01() {
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customer);
		assertNotNull (bookingService.addBooking(booking));
	}
	
	@Test
	public void removeBookingTest01() throws Exception{
		try {
			bookingService.removeBooking(678);
		}
		catch(NotFoundException ex) {
		assertEquals("Booking id is not valid",ex.getMessage());
		}
		
	}
	
	@Test
	public void updateBookingTest01() throws NotFoundException{
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customer);
		try {
			bookingService.updateBooking(234, booking);
		}
		catch(NotFoundException ex) {
			assertEquals("Booking Id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getBookingTest01() throws Exception{
		try {
			bookingService.getBooking(123);
		}
		catch(NotFoundException ex) {
			assertEquals("Booking id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getAllBookingsTest01() {
		assertNotNull (bookingService.getAllBookings());
	}
	
	@Test
	public void getBookingsByDate01() {

			List<Booking> lb=(bookingService.getBookingsByDate(LocalDate.parse("2025-03-04")));
			assertThat(lb, IsEmptyCollection.empty());
			
	}
	
}
