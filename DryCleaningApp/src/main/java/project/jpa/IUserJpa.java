package project.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import project.models.User;

public interface IUserJpa extends JpaRepository<User, String> {
	User findByUserIdAndPassword(User user);
}
