package project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.models.User;
import project.repository.IUserRepository;
@Service
public class UserService implements IUserService{
	@Autowired
	private IUserRepository userRepository;
	
	
	public User signIn(User user) {
		return userRepository.signIn(user);
	}
	
	public User signOut(User user) {
		return userRepository.signOut(user);
	}
	
	public User changePassword(long id, User user) {
		return userRepository.changePassword(id, user);
	}
	
	
}
