package com.generics.restaurant_platform.api.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Map;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private boolean status;

    private int restaurantId;

    private int userId;

    @Convert(converter = com.generics.restaurant_platform.api.services.ListToString.class)
    private ArrayList< Map<String, Object> > dishes;

    public Order(boolean status, int restaurantId, int userId, ArrayList< Map<String, Object> > dishes) {
        this.status = status;
        this.restaurantId = restaurantId;
        this.userId = userId;
        this.dishes = dishes;
    }

    public Order() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<Map<String, Object> > getDishes() {
        return dishes;
    }

    public void setDishes(ArrayList<Map<String, Object> > dishes) {
        this.dishes = dishes;
    }


}
