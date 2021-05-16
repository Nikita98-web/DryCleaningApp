package project.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.models.Booking;
import project.repository.IBookingRepository;

@Service
public class BookingService implements IBookingService {
	@Autowired
	private IBookingRepository bookingRepository;
	
	public Booking addBooking(Booking booking) {
		return bookingRepository.addBooking(booking);
	}
	
	public Booking removeBooking(long bookingId) {
		return bookingRepository.removeBooking(bookingId);
	}
	
	public Booking updateBooking(long bookingId, Booking booking) {
		return bookingRepository.updateBooking(bookingId, booking);
	}
	
	public Booking getBooking(long bookingId) {
		return bookingRepository.getBooking(bookingId);
	}
	
	public List<Booking> getAllBookings(){
		return bookingRepository.getAllBookings();
	}
	
	public List<Booking> getBookingsByDate(LocalDate date){
		return bookingRepository.getBookingsByDate(date);
	}
	
	public List<Booking>getBookingsByCustomer(long customerId){
		return bookingRepository.getBookingsByCustomer(customerId);
	}
}
