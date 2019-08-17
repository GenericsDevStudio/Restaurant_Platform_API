package com.generics.restaurant_platform.api.database.order;

import com.generics.restaurant_platform.api.entities.Order;
import com.generics.restaurant_platform.api.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderDataBaseController {
    @Autowired
    private OrderTable orderTable;

    public void addOrder(Order order) {
        orderTable.save(order);
    }

    public List<Order> getAllOrders() {
        return orderTable.findAll();
    }

    public List<Order> getAllUserOrders(int userId) {
        return orderTable.findByUserId(userId);
    }

    public List<Order> getAllRestaurantOrders(int restaurantId) {
        return orderTable.findByRestaurantId(restaurantId);
    }

    public List<Order> getAllRestaurantStatusOrders(int restarantId, boolean status) {
        return orderTable.findByRestaurantIdAndStatus(restarantId, status);
    }

    public Order getOrder(int id) {
        return orderTable.findById(id);
    }
}

