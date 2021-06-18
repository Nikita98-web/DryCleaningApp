package project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import project.controller.UserController;
import project.exception.NotFoundException;
import project.models.User;
import project.services.IUserService;

@SpringBootTest
public class UserControllerTest {
	static final Logger LOGGER = LoggerFactory.getLogger(UserControllerTest.class);
	@Autowired
	private UserController userController;
	
	User user=null;
	
	
	@Test
	public void signInTest01() throws NotFoundException{
		LOGGER.info("signInTest01 method executed");
		user=new User("7","xyz");
		try {
		assertEquals(userController.signIn(user).getStatusCode(),HttpStatus.ACCEPTED);
		}
		catch(NotFoundException ex) {
			assertEquals("UserId or Password is not correct",ex.getMessage());
		}
	}
	
	@Test
	public void signOutTest01() {
		LOGGER.info("signOutTest01 method executed");
		user=new User("7","xyz");
		assertEquals(userController.signOut(user).getStatusCode(),HttpStatus.OK);
	}
	
	@Test
	public void changePasswordTest01() throws NotFoundException{
		LOGGER.info("signOutTest01 method executed");
		user=new User("7","xyz");
		try {
		assertEquals(userController.changePassword("7", user).getStatusCode(),HttpStatus.ACCEPTED);
		}
		catch(NotFoundException ex) {
			assertEquals("User Id is not valid",ex.getMessage());
		}
		
	}
}
