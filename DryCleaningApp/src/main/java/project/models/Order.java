package project.models;

import java.time.LocalDate;

import javax.persistence.*;
@Entity
@Table(name="order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	private long orderId;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="billing_date")
	private LocalDate billingDate;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Customer customer;
	
	@Column(name="payment_method")
	private String paymentMethod;
	
	@Column(name="booking_details")
	private Booking bookingDetails;
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Booking getBookingDetails() {
		return bookingDetails;
	}
	public void setBookingDetails(Booking bookingDetails) {
		this.bookingDetails = bookingDetails;
	}
}
