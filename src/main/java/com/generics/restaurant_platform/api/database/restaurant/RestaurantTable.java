package com.generics.restaurant_platform.api.sql.restaurant;

import com.generics.restaurant_platform.api.entities.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantTable extends CrudRepository<Restaurant, Integer> {

}
