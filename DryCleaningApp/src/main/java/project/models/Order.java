package project.models;

import java.time.LocalDate;

public class Order {
	private long orderId;
	private double amount;
	private LocalDate billingDate;
	private Customer customer;
	private String paymentMethod;
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
