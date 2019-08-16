package com.generics.restaurant_platform.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int categoryId;

    private String name;
    private String description;
    private String price;


    public Dish(int categoryId, String name, String description, String price) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Dish() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
