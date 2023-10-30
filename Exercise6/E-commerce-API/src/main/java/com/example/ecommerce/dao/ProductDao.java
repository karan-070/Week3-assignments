package com.example.ecommerce.dao;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {
    List<Product> findByCustomer(Customer customer);

}
