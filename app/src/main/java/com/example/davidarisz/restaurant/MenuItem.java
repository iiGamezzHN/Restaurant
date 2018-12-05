package com.example.davidarisz.restaurant;

import java.io.Serializable;

public class MenuItem implements Serializable {
    private String name, description, imgUrl, category;
    private int price;

    public MenuItem(String name, String description, String imgUrl, int price, String category) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
        this.category = category;
    }

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

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public void setPrice(int price) {
        this.price = price;
    }
}
