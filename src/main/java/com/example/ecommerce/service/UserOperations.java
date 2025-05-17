package com.example.ecommerce.service;

import com.example.ecommerce.model.UserData;

public interface UserOperations {
    String addToCart(UserData user, String productName, int quantity);
    String checkout(UserData user);
}
