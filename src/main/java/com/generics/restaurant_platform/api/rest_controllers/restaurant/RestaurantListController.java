package com.generics.restaurant_platform.api.rest_controllers.restaurant;

import com.generics.restaurant_platform.api.entities.Restaurant;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.json_answers.ListAnswer;
import com.generics.restaurant_platform.api.database.restaurant.RestaurantDataBaseController;
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
    public Answer restaurantList() {
        List<Restaurant> list = restaurantDataBaseController.getAllRestaurants();
        return new ListAnswer<>(200, "OK", list);
    }
}
