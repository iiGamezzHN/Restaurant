package com.example.davidarisz.restaurant;

import java.io.Serializable;

public class MenuItem implements Serializable {
    // Initialize all the variables used in the class
    private String name, description, imgUrl, category;
    private int price;

    // Constructor for the class
    public MenuItem(String name, String description, String imgUrl, int price, String category) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
        this.category = category;
    }

    // All the getters and setters for the variables
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }
}
