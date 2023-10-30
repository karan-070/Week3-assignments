package com.example.ecommerce.component;

import com.example.ecommerce.dao.CustomerDao;
import com.example.ecommerce.dao.OrderDao;
import com.example.ecommerce.dao.ProductDao;
import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private ProductDao productDao;
    @Autowired
    private OrderDao orderDao;

    @Override
    public void run(String... args) throws Exception {
        Customer customer1 = new Customer();
        customer1.setUsername("johndoe123");
        customer1.setPassword("SecurePass123");
        customer1.setEmail("john.doe@email.com");
        customerDao.save(customer1);

        Customer customer2 = new Customer();
        customer2.setUsername("sarasmith22");
        customer2.setPassword("StrongPassword!");
        customer2.setEmail("sara.smith@email.com");
        customerDao.save(customer2);

        Customer customer3 = new Customer();
        customer3.setUsername("mikewilson");
        customer3.setPassword("P@ssw0rd789");
        customer3.setEmail("mike.wilson@email.com");
        customerDao.save(customer3);

        Customer customer4 = new Customer();
        customer4.setUsername("lindajames");
        customer4.setPassword("Secret1234");
        customer4.setEmail("linda.james@email.com");
        customerDao.save(customer4);

        Customer customer5 = new Customer();
        customer5.setUsername("chrisbrown");
        customer5.setPassword("C0mpl3xP@ss");
        customer5.setEmail("chris.brown@email.com");
        customerDao.save(customer5);

        // Sample product data
        Product product1 = new Product();
        product1.setName("Laptop");
        product1.setPrice(799.99);
        productDao.save(product1);

        Product product2 = new Product();
        product2.setName("Smartphone");
        product2.setPrice(499.99);
        productDao.save(product2);

        Product product3 = new Product();
        product3.setName("Smart TV");
        product3.setPrice(899.99);
        productDao.save(product3);

        Product product4 = new Product();
        product4.setName("Headphones");
        product4.setPrice(79.99);
        productDao.save(product4);

        Product product5 = new Product();
        product5.setName("Digital Camera");
        product5.setPrice(349.99);
        productDao.save(product5);

        createOrder(customer1, LocalDateTime.of(2023, 10, 29, 10, 15), product1);
        createOrder(customer2, LocalDateTime.of(2023, 10, 29, 11, 30), product2);
        createOrder(customer3, LocalDateTime.of(2023, 10, 29, 13, 45), product3);
        createOrder(customer4, LocalDateTime.of(2023, 10, 29, 15, 0), product4);
        createOrder(customer5, LocalDateTime.of(2023, 10, 29, 16, 15), product5);

    }

    private void createOrder(Customer customer, LocalDateTime orderTime, Product product) {
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(LocalDateTime.now());
        order.getOrderedProducts().add(product);
        orderDao.save(order);
    }
}
