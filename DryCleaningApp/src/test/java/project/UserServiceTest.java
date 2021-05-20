package project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import project.exception.NotFoundException;
import project.models.Address;
import project.models.Booking;
import project.models.Customer;
import project.models.User;
import project.services.IUserService;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
public class UserServiceTest {
	@Autowired
	private IUserService userService;
	
	User user=null;
	
	
	@Test
	public void signInTest01() throws NotFoundException{
		user=new User("386","jsdeus");
		try {
		userService.signIn(user);
		}
		catch(NotFoundException ex) {
		assertEquals("UserId or Password is not correct",ex.getMessage());
		}
	}
	
	@Test
	public void signOutTest01() {
		user=new User("386","jsdeus");
		assertEquals(userService.signOut(user),user);
	}
	
	@Test
	public void changePasswordgTest01() throws NotFoundException{
		user=new User("386","jsdeus");
		try {
			userService.changePassword(639, user);
		}
		catch(NotFoundException ex) {
			assertEquals("User Id is not valid",ex.getMessage());
		}
	}
}
