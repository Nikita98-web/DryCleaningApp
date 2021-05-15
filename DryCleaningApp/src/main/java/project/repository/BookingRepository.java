package project.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import project.jpa.*;
import project.models.*;

public class BookingRepository implements IBookingRepository {
	
	@Autowired
	private IBookingJpa bookingjpa;
	
	@Autowired
	private ICustomerJpa customerjpa;
	
	public Booking addBooking(Booking booking) {
		 bookingjpa.save(booking);
		 return booking;
	}
	
	public Booking removeBooking(long bookingId) {
		Booking b=bookingjpa.findById(bookingId).get();
		bookingjpa.delete(b);
		return b;
	}
	
	public Booking updateBooking(long bookingId, Booking booking) {
		Booking b= bookingjpa.findById(bookingId).get();
		b.setBookingId(booking.getBookingId());
		b.setBookingDate(booking.getBookingDate());
		b.setBookingTime(booking.getBookingTime());
		b.setCustomerDetails(booking.getCustomerDetails());
		b.setServiceType(booking.getServiceType());
		bookingjpa.save(b);
		return b;
	}
	
	public Booking getBooking(long bookingId) {
		Booking b= bookingjpa.findById(bookingId).get();
		return b;
	}
	
	public List<Booking> getAllBookings(){
		List<Booking> b=bookingjpa.findAll();
		return b;
	}
	
	public List<Booking> getBookingsByDate(LocalDate date){
		List<Booking> b = bookingjpa.findByBookingDate(date);
		return b;
	}
	
	public List<Booking> getBookingsByCustomer(long customerId){
		Customer c = customerjpa.findById(Long.toString(customerId)).get();
		List<Booking> b= bookingjpa.findByCustomerDetails(c);
		return b;
	}
}
