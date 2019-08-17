package com.generics.restaurant_platform.api.database.order;

import com.generics.restaurant_platform.api.entities.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderTable extends CrudRepository<Order, Integer> {
    List<Order> findAll();
    List<Order> findByStatus(boolean status);
    List<Order> findByUserId(int userId);
    List<Order> findByRestaurantId(int restaurantId);
    List<Order> findByRestaurantIdAndStatus(int restaurantId, boolean status);
    Order findById(int id);
}
