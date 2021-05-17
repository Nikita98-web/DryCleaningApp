package project.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.jpa.IUserJpa;
import project.models.User;
@Repository
public class UserRepository implements IUserRepository{
	@Autowired
	private IUserJpa userjpa;
	

	public User signIn(User user) {
		User u = userjpa.findByUserIdAndPassword(user.getUserId(), user.getPassword());
		return u;
		
	}
	
	public User signOut(User user) {
		return user;
	}
	
	public User changePassword(long id, User user) {
		User u=userjpa.findById(Long.toString(id)).get();
		u.setPassword(user.getPassword());
		userjpa.save(u);
		return u;
	}
}
