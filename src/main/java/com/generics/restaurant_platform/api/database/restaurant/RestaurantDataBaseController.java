package com.generics.restaurant_platform.api.database.restaurant;

import com.generics.restaurant_platform.api.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RestaurantDataBaseController {

    @Autowired
    private RestaurantTable restaurantTable;

    public void addRestaurant(Restaurant restaurant) {
        restaurantTable.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantTable.findAll();
    }
}
