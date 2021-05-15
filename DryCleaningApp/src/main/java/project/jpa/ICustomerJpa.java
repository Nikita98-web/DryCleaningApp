package project.jpa;
import project.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerJpa extends JpaRepository<Customer, String>{
	
}
