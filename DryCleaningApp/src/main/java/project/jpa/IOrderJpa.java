package project.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import project.models.Order;

public interface IOrderJpa extends JpaRepository <Order, Long> {

}
