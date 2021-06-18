package project.services;

import project.exception.*;
import project.models.*;

public interface IUserService {
	User signIn(User user) throws NotFoundException;
	User signOut(User user);
	User changePassword(String id, User user)throws NotFoundException;
}
