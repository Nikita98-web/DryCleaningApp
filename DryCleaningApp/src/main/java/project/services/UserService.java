package project.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.exception.*;
import project.models.User;
import project.repository.IUserRepository;
@Service
public class UserService implements IUserService{
	static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private IUserRepository userRepository;
	
	//sign in for user
	public User signIn(User user) throws NotFoundException {
		LOGGER.info("User service - SignIn method executed");
		return userRepository.signIn(user) ;
	}
	
	//Sign out for user
	public User signOut(User user) {
		LOGGER.info("User service - SignOut method executed");
		return userRepository.signOut(user);
	}
	
	//Change password for user
	public User changePassword(String id, User user) throws NotFoundException{
		LOGGER.info("User service - ChangePassword method executed");
		return userRepository.changePassword(id, user);
	}
	
	
}
