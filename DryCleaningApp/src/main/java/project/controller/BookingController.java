package project.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import project.exception.NotFoundException;
import project.models.Booking;
import project.models.Customer;
import project.services.IBookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	@Autowired
	private IBookingService bookingService;
	
	@PostMapping("/add")
	public Booking addBooking(@RequestBody Booking booking) {
		return bookingService.addBooking(booking);
	}
	
	@DeleteMapping("/remove/{bookingId}")
	public ResponseEntity<Object> removeBooking(@PathVariable long bookingId) throws Exception {
		ResponseEntity<Object> response=null;
		Booking b = bookingService.removeBooking(bookingId);
		response=new ResponseEntity<Object>(b,HttpStatus.OK);
		return response;
	}
	
	
	@PutMapping("/update/{bookingId}")
	public ResponseEntity<Object> updateBooking(@PathVariable long bookingId, @RequestBody Booking booking) throws NotFoundException {
		ResponseEntity<Object>response=null;
		Booking b = bookingService.updateBooking(bookingId, booking);
		response=new ResponseEntity<>(b, HttpStatus.ACCEPTED);
		return response;
}

	
	@GetMapping("/get/{bookingId}")
	public ResponseEntity <Object> getBooking(@PathVariable long bookingId) throws Exception{
		ResponseEntity <Object>response=null;
		Booking b=bookingService.getBooking(bookingId);
		response=new ResponseEntity<>(b, HttpStatus.ACCEPTED);		
		return response;
	}
	
	@GetMapping("/get")
	public List<Booking> getAllBookings(){
		return bookingService.getAllBookings();
	}
	
	@GetMapping("/getbydate/{date}")
	public List<Booking> getBookingsByDate(@PathVariable String date){
		LocalDate myDate=LocalDate.parse(date);
		return bookingService.getBookingsByDate(myDate);
	}
	
	@GetMapping("/getbycustomer/{customerId}")
	public ResponseEntity<Object> getBookingsByCustomer(@PathVariable long customerId) throws Exception{
		ResponseEntity<Object>response=null;
		List<Booking> lb=bookingService.getBookingsByCustomer(customerId);
		response=new ResponseEntity<>(lb, HttpStatus.ACCEPTED);		
		return response;
	}
}
	
