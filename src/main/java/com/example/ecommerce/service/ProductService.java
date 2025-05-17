package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService implements AdminOperations {
    private final Map<String, Product> productMap = new HashMap<>();

    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    public void addProduct(Product product) {
        productMap.put(product.getName(), product);
    }

    public void updateProduct(String name, Product updatedProduct) {
        productMap.put(name, updatedProduct);
    }

    public void deleteProduct(String name) {
        productMap.remove(name);
    }

    public Product getProduct(String name) {
        return productMap.get(name);
    }
}
