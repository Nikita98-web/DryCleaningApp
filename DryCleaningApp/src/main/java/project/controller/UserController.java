package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import project.models.User;
import project.services.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	
	@GetMapping("/getsignin")
	public User signIn(@RequestBody User user) {
		return userService.signIn(user);
	}
	
	@GetMapping("/getsignout")
	public User signOut(@RequestBody User user) {
		return userService.signOut(user);
	}
	
	@PutMapping("/update/{id}")
	public User changePassword(@PathVariable long id,@RequestBody User user) {
		return userService.changePassword(id, user);
	}
	
}
