package project.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import project.models.Booking;
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
	public Booking removeBooking(@PathVariable long bookingId) {
		return bookingService.removeBooking(bookingId);
	}
	
	@PutMapping("/update/{bookingId}")
	public Booking updateBooking(@PathVariable long bookingId, @RequestBody Booking booking) {
		return bookingService.updateBooking(bookingId, booking);
	}
	
	@GetMapping("/get/{bookingId}")
	public Booking getBooking(@PathVariable long bookingId) {
		return bookingService.getBooking(bookingId);
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
	public List<Booking>getBookingsByCustomer(@PathVariable long customerId){
		return bookingService.getBookingsByCustomer(customerId);
	}
}
