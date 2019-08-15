package com.generics.restaurant_platform.api.sql.restaurant;

import com.generics.restaurant_platform.api.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RestaurantDataBaseController {

    @Autowired
    private RestaurantTable restaurantTable;

    public Restaurant addRestaurant(String name, String address) {
        Restaurant restaurant = new Restaurant(name, address);
        restaurantTable.save(restaurant);
        return restaurant;
    }

    public Iterable<Restaurant> getAllRestaurants() {
        return restaurantTable.findAll();
    }
}
