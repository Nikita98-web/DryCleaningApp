package project.jpa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.models.Booking;
import project.models.Customer;

public interface IBookingJpa extends JpaRepository<Booking, Long> {
	List<Booking> findByBookingDate(LocalDate date);
	List<Booking> findByCustomerDetails(Customer customer);
}
