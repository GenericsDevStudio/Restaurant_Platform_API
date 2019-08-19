package com.generics.restaurant_platform.api.rest_controllers.dish;

import com.generics.restaurant_platform.api.database.dish.DishDataBaseController;
import com.generics.restaurant_platform.api.entities.Dish;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.json_answers.RegistrationAnswer;
import com.generics.restaurant_platform.api.services.CheckPermission;
import com.generics.restaurant_platform.api.user_types.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;

@RestController
public class DishAddingController {
    @Autowired
    private DishDataBaseController dishDataBaseController;
    @Autowired
    private CheckPermission checkPermission;
    private HashSet<UserType> userTypes;

    public void setUserTypes(UserType... ust) {
        userTypes.addAll(Arrays.asList(ust));
    }
    public DishAddingController() {
        userTypes = new HashSet<>();
        setUserTypes(UserType.ADMIN);
    }

    @RequestMapping(value = "/addDish", method = RequestMethod.POST)
    public Answer addDish(String token, int categoryId, String name, String description, String price) {
        if(userTypes.contains(checkPermission.checkPermisson(token))) {
            if(dishDataBaseController.findDish(name) == null) {
                Dish dish = new Dish(categoryId, name, description, price);
                dishDataBaseController.addDish(dish);
                return new RegistrationAnswer(200, "OK", dish.getId());
            } else {
                return new Answer(400, "Dish already exists");
            }
        } else {
            return new Answer(403, "Permission denied");
        }
    }
}
