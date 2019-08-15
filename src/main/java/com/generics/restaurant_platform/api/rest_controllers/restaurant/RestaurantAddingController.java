package com.generics.restaurant_platform.api.rest_controllers;

import com.generics.restaurant_platform.api.entities.Restaurant;
import com.generics.restaurant_platform.api.json_answers.RegistrationAnswer;
import com.generics.restaurant_platform.api.sql.restaurant.RestaurantDataBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantAddingController {

    @Autowired
    private RestaurantDataBaseController restaurantDataBaseController;

    @RequestMapping(value = "/addRestaurant")
    public RegistrationAnswer addRestaurant(String name, String address) {
        Restaurant restaurant = restaurantDataBaseController.addRestaurant(name, address);
        return new RegistrationAnswer(200, restaurant.getId());
    }
}
