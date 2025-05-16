package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String addProduct(@RequestParam String user, @RequestBody Product product) {
        if (!user.equals("admin")) {
            return "Only admin can access this field";
        }
        productService.addProduct(product);
        return "The product has been successfully added";
    }

    @PutMapping("/update/{name}")
    public String updateProduct(@RequestParam String user, @PathVariable String name, @RequestBody Product product) {
        if (!user.equals("admin")) {
            return "Only admin can access this field";
        }
        productService.updateProduct(name, product);
        return "The product has been successfully updated";
    }

    @DeleteMapping("/delete/{name}")
    public String deleteProduct(@RequestParam String user, @PathVariable String name) {
        if (!user.equals("admin")) {
            return "Only admin can access this field";
        }
        productService.deleteProduct(name);
        return "The product has been successfully deleted";
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
}
