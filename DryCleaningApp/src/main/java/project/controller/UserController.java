package project.controller;

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
	@Autowired
	private IUserService userService;
	
	
	@GetMapping("/getsignin")
	public ResponseEntity<Object> signIn(@RequestBody User user) throws NotFoundException {
		ResponseEntity <Object>response=null;
		User u=userService.signIn(user);
		response=new ResponseEntity<>(u, HttpStatus.ACCEPTED);
		return response;
	}
	
	@GetMapping("/getsignout")
	public User signOut(@RequestBody User user) {
		return userService.signOut(user);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> changePassword(@PathVariable long id,@RequestBody User user) throws NotFoundException{
		ResponseEntity <Object>response=null;
			User u= userService.changePassword(id, user);
			response=new ResponseEntity<>(u, HttpStatus.ACCEPTED);
		return response;
	}
	
}
