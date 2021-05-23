package project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;

import project.exception.*;
import project.models.User;
import project.services.IUserService;


@RestController
@RequestMapping("/user")
public class UserController {
	static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private IUserService userService;
	
	//Get sign in
	@PostMapping("/getsignin")
	public ResponseEntity<Object> signIn(@RequestBody User user) throws NotFoundException {
		LOGGER.info("/User/getsignin URL is opened");
		LOGGER.info("SignIn method executed");
		ResponseEntity <Object>response=null;
		User u=userService.signIn(user);
		response=new ResponseEntity<>(u, HttpStatus.ACCEPTED);
		return response;
	}
	
	//Get sign out
	@PostMapping("/getsignout")
	public ResponseEntity<Object> signOut(@RequestBody User user) {
		ResponseEntity<Object> response=null;
		LOGGER.info("/User/getsignOut URL is opened");
		LOGGER.info("SignOut method executed");
		User u = userService.signOut(user);
		response=new ResponseEntity<Object>(u,HttpStatus.OK);
		return response;
	}
	
	//Update Password by id
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> changePassword(@PathVariable long id,@RequestBody User user) throws NotFoundException{
		LOGGER.info("/User/update/{id} URL is opened");
		LOGGER.info("ChangePassword method executed");
		ResponseEntity <Object>response=null;
			User u= userService.changePassword(id, user);
			response=new ResponseEntity<>(u, HttpStatus.ACCEPTED);
		return response;
	}
	
}
