package com.example.ecommerce.model;

public class Product {
    private String name;
    private double price;
    private int sale;

    public Product() {};

    public Product(String name, double price, int sale) {
        this.name = name;
        this.price = price;
        this.sale = sale;
    }
    //Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getSale() { return sale; }

    //Setter
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setSale(int sale) { this.sale = sale; }
}
