package project.repository;

import project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository {
	User signIn(User user);
	User signOut(User user);
	User changePassword(long id, User user);
}
