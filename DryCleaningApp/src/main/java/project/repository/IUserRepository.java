package project.repository;

import project.exception.NotFoundException;
import project.models.User;

public interface IUserRepository {
	User signIn(User user)throws NotFoundException;
	User signOut(User user);
	User changePassword(long id, User user)throws NotFoundException;
}
