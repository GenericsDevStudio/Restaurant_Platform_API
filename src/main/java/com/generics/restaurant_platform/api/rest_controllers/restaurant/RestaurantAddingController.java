package com.generics.restaurant_platform.api.rest_controllers.restaurant;

import com.generics.restaurant_platform.api.entities.Restaurant;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.json_answers.RegistrationAnswer;
import com.generics.restaurant_platform.api.database.restaurant.RestaurantDataBaseController;
import com.generics.restaurant_platform.api.services.CheckPermission;
import com.generics.restaurant_platform.api.user_types.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;

@RestController
public class RestaurantAddingController {
    @Autowired
    private RestaurantDataBaseController restaurantDataBaseController;
    @Autowired
    private CheckPermission checkPermission;
    private HashSet<UserType> userTypes;

    public void setUserTypes(UserType... ust) {
        userTypes.addAll(Arrays.asList(ust));
    }
    public RestaurantAddingController() {
        userTypes = new HashSet<>();
        setUserTypes(UserType.ADMIN);
    }

    @RequestMapping(value = "/addRestaurant", method = RequestMethod.POST)
    public Answer addRestaurant(String token, String name, String address) {
        if(userTypes.contains(checkPermission.checkPermisson(token))) {
            Restaurant restaurant = new Restaurant(name, address);
            restaurantDataBaseController.addRestaurant(restaurant);
            return new RegistrationAnswer(200, "OK", restaurant.getId());
        } else {
            return new Answer(403, "Permission denied");
        }
    }
}
