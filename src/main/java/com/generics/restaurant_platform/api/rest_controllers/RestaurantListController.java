package com.generics.restaurant_platform.api.rest_controllers;

import com.generics.restaurant_platform.api.entities.Restaurant;
import com.generics.restaurant_platform.api.json_answers.ListAnswer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestaurantListController {

    @RequestMapping(value = "/restaurantList", method = RequestMethod.GET)
    public ListAnswer<Restaurant> restaurantList() {
        //TODO getting restaturant list from database

        return new ListAnswer<Restaurant>(
                new Restaurant("First address", "First res"),
                new Restaurant("Second address", "Second res"),
                new Restaurant("Third address", "Third res"));
    }
}
