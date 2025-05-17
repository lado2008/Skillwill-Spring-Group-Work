package com.example.ecommerce.service;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements UserOperations {

    private final ProductService productService;

    @Autowired
    public CartService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String addToCart(UserData user, String productName, int amount) {
        Product product = productService.getProduct(productName);
        if (product == null){
            return "Product not found!";
        }
        if (product.getStock() < amount) {
            return "Not enough stock!";
        }
        user.getCart().add(new Cart(product, amount));
        return "Product added to cart successfully";
    }

    @Override
    public String checkout(UserData user) {
        double total = 0;
        for (Cart item : user.getCart()) {
            if (item.getProduct().getStock() < item.getAmount()) {
                return "Not enough stock for: " + item.getProduct().getName();
            }
            total += item.getProduct().getPrice() * item.getAmount();
        }
        if (user.getBudget() < total) {
            return "Insufficient budget!";
        }
        for (Cart item : user.getCart()) {
            Product product = item.getProduct();
            product.setStock(product.getStock() - item.getAmount());
        }

        user.setBudget(user.getBudget() - total);
        user.getCart().clear();
        return "Checkout complete, remaining budget: " + user.getBudget();
    }
}
