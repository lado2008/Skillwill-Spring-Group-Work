package com.example.ecommerce.controller;

import com.example.ecommerce.model.*;
import com.example.ecommerce.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserData data = new UserData("user");

    private final UserOperations userOperations;
    private final AdminOperations adminOperations;

    @Autowired
    public UserController(UserOperations userOperations, AdminOperations adminOperations) {
        this.userOperations = userOperations;
        this.adminOperations = adminOperations;
    }

    @GetMapping("/products")
    public Object viewProducts(@RequestParam String user) {
        if (!user.equals("user")) {
            return "Access denied";
        }
        return adminOperations.getAllProducts();
    }

    @PostMapping("/cart/add")
    public String add(@RequestParam String user, @RequestParam String product, @RequestParam int quantity) {
        if (!user.equals("user")) {
            return "Access denied. Try again!";
        }
        return userOperations.addToCart(data, product, quantity);
    }

    @PostMapping("/cart/checkout")
    public String buy(@RequestParam String user) {
        if (!user.equals("user")) {
            return "Access denied. Try again!";
        }
        return userOperations.checkout(data);
    }

    @GetMapping("/budget")
    public double budget(@RequestParam String user) {
        if (!user.equals("user")) {
            System.out.println("Access denied. Try again!");
            return 0;
        }
        return data.getBudget();
    }
}
