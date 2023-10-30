package com.example.ecommerce.service;

import com.example.ecommerce.dao.CustomerDao;
import com.example.ecommerce.dao.OrderDao;
import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CustomerDao customerDao;

    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }

    public Order getOrderById(Long orderId) {
        return orderDao.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));
    }

    public Order createOrder(Order order, Long customerId) {
        Customer customer = customerDao.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
        order.setCustomer(customer);
        return orderDao.save(order);
    }

    public Order updateOrder(Long orderId, Order order) {
        Order existingOrder = orderDao.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));
        return orderDao.save(existingOrder);
    }

    public void deleteOrder(Long orderId) {
        Order existingOrder = orderDao.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));
        orderDao.delete(existingOrder);
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderDao.findByCustomerId(customerId);
    }
}
