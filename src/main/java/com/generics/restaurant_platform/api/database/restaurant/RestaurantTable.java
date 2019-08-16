package com.generics.restaurant_platform.api.database.restaurant;

import com.generics.restaurant_platform.api.entities.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantTable extends CrudRepository<Restaurant, Integer> {
    List<Restaurant> findAll();
}
