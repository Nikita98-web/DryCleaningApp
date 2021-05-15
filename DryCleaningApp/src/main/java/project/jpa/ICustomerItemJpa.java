package project.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.models.CustomerItem;

public interface ICustomerItemJpa extends JpaRepository<CustomerItem , Long>{
	List<CustomerItem> findByCustomer(long customerId);
}
