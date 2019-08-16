package com.generics.restaurant_platform.api.rest_controllers.restaurant;

import com.generics.restaurant_platform.api.entities.Restaurant;
import com.generics.restaurant_platform.api.json_answers.RegistrationAnswer;
import com.generics.restaurant_platform.api.database.restaurant.RestaurantDataBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantAddingController {

    @Autowired
    private RestaurantDataBaseController restaurantDataBaseController;

    @RequestMapping(value = "/addRestaurant", method = RequestMethod.GET)
    public RegistrationAnswer addRestaurant(String name, String address) {
        Restaurant restaurant = restaurantDataBaseController.addRestaurant(name, address);
        return new RegistrationAnswer(200, "OK", restaurant.getId());
    }
}
