package com.generics.restaurant_platform.api.rest_controllers;

import com.generics.restaurant_platform.api.entities.Restaurant;
import com.generics.restaurant_platform.api.json_answers.ListAnswer;
import com.generics.restaurant_platform.api.sql.restaurant.RestaurantDataBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class RestaurantListController {

    @Autowired
    private RestaurantDataBaseController restaurantDataBaseController;

    @RequestMapping(value = "/restaurantList", method = RequestMethod.GET)
    public ListAnswer<Restaurant> restaurantList() {
        Iterable<Restaurant> iterable = restaurantDataBaseController.getAllRestaurants();

        List<Restaurant> list = new ArrayList<>();
        iterable.forEach(res -> {
            list.add(res);
        });

        return new ListAnswer<>(200, list);
    }
}
