package project.models;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customer {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
  private String userId;
	
	@Column(name="name")
  private String name;
	
	@Column(name="email")
  private String email;
	
	@Column(name="contact_no")
  private String contactNo;
	
	@Column(name="dob")
  private LocalDate dob;
	
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="door_no")
  private Address address;

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getContactNo() {
	return contactNo;
}

public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}

public LocalDate getDob() {
	return dob;
}

public void setDob(LocalDate dob) {
	this.dob = dob;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}
  
  
}
