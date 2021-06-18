package project.models;

import java.time.*;

import javax.persistence.*;
@Entity
@Table(name="bookings")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="booking_id")
	private long bookingId;
	
	@Column(name="booking_date")
	private LocalDate bookingDate;
	
	@Column(name="booking_time")
	private LocalTime bookingTime;
	
	@Column(name="service_type")
	private String serviceType;
	
	/*@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="user_id")
	private Customer customerDetails;*/
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="customer_item_id")
	private CustomerItem customerItem;
	
	public Booking() {
		
	}
	
	

	public Booking(long bookingId, LocalDate bookingDate, LocalTime bookingTime, String serviceType,
			CustomerItem customerItem) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.serviceType = serviceType;
		this.customerItem = customerItem;
	}
	
	public CustomerItem getCustomerItem() {
		return customerItem;
	}

	public void setCustomerItem(CustomerItem customerItem) {
		this.customerItem = customerItem;
	}
	
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public LocalTime getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(LocalTime bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
}
