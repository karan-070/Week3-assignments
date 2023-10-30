package com.example.ecommerce.service;

import com.example.ecommerce.dao.CustomerDao;
import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }
    public Customer getCustomerById(Long customerId) {
        return customerDao.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
    }
    public Customer registerCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    public Customer loginCustomer(String username, String password) {
        Customer customer = customerDao.findByUsername(username);
        if (customer != null && customer.getPassword().equals(password)) {
            return customer;
        } else {
            throw new ResourceNotFoundException("Customer", "username", username);
        }
    }

    public Customer updateProfile(Customer customer) {
        Customer existingCustomer = customerDao.findById(customer.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customer.getId()));
        existingCustomer.setUsername(customer.getUsername());
        existingCustomer.setPassword(customer.getPassword());
        existingCustomer.setEmail(customer.getEmail());
        return customerDao.save(existingCustomer);
    }

    private CustomerDTO convertToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setUsername(customer.getUsername());
        customerDTO.setEmail(customer.getEmail());
        // You might not want to expose the password in the DTO
        // customerDTO.setPassword(customer.getPassword());
        return customerDTO;

}

    public void deleteCustomer(Long customerId) {
        customerDao.deleteById(customerId);
    }
}


