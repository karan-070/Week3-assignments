package com.example.ecommerce.dao;

import com.example.ecommerce.model.Customer;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Long> {
    Customer findByUsername(String username);

}