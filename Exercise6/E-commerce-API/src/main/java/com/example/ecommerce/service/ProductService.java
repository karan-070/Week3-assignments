package com.example.ecommerce.service;

import com.example.ecommerce.dao.ProductDao;
import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    public Product getProductById(Long productId) {
        return productDao.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
    }

    public Product createProduct(Product product) {
        return productDao.save(product);
    }

    public Product updateProduct(Long productId, Product product) {
        Product existingProduct = productDao.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return productDao.save(existingProduct);
    }

    public void deleteProduct(Long productId) {
        Product existingProduct = productDao.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
        productDao.delete(existingProduct);
    }
}