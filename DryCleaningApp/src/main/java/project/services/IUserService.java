package project.services;

import project.models.*;

public interface IUserService {
	User signIn(User user);
	User signOut(User user);
	User changePassword(long id, User user);
}
