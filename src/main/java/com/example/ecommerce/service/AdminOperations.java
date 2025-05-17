package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;

import java.util.List;

public interface AdminOperations {
    void addProduct(Product product);
    void updateProduct(String name, Product product);
    void deleteProduct(String name);
    List<Product> getAllProducts();
}
