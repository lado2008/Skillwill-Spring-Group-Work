package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.AdminOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminOperations adminOperations;

    @Autowired
    public AdminController(AdminOperations adminOperations) {
        this.adminOperations = adminOperations;
    }

    @PostMapping("/add")
    public String add(@RequestParam String user, @RequestBody Product product) {
        if (!user.equals("admin")) {
            return "Only admin has access to this field!";
        }
        adminOperations.addProduct(product);
        return "Product added successfully";
    }

    @PutMapping("/update/{name}")
    public String update(@RequestParam String user, @PathVariable String name, @RequestBody Product product) {
        if (!user.equals("admin")) {
            return "Only admin has access to this field!";
        }
        adminOperations.updateProduct(name, product);
        return "Product updated successfully";
    }

    @DeleteMapping("/delete/{name}")
    public String delete(@RequestParam String user, @PathVariable String name) {
        if (!user.equals("admin")) {
            return "Only admin has access to this field!";
        }
        adminOperations.deleteProduct(name);
        return "Product deleted successfully";
    }

    @GetMapping("/products")
    public List<Product> list() {
        return adminOperations.getAllProducts();
    }
}
