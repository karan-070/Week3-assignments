package com.example.ecommerce.model;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    private Long id;
    private LocalDateTime orderDate;
    private String customerName;
    private List<ProductDTO> orderedProducts;

    public OrderDTO(Long id, LocalDateTime orderDate, String customerName, List<ProductDTO> orderedProducts) {
        this.id = id;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.orderedProducts = orderedProducts;
    }

    public OrderDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<ProductDTO> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<ProductDTO> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }
}
