package com.example.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    private String username;
    private double budget;
    private List<Cart> cart;

    public UserData() {
        this.budget = 1000;
        this.cart = new ArrayList<>();
    }

    public UserData(String username) {
        this.username = username;
        this.budget = 1000;
        this.cart = new ArrayList<>();
    }

    public void setBudget(double budget) { this.budget = budget; }
    public void setUsername(String username) { this.username = username; }
    public void setCart(List<Cart> cart) { this.cart = cart; }

    public String getUsername() { return username; }
    public double getBudget() { return budget; }
    public List<Cart> getCart() { return cart; }
}
