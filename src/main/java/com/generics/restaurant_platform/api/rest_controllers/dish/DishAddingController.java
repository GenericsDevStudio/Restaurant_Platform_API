package com.generics.restaurant_platform.api.rest_controllers.dish;

import com.generics.restaurant_platform.api.database.dish.DishDataBaseController;
import com.generics.restaurant_platform.api.entities.Dish;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.json_answers.RegistrationAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishAddingController {

    @Autowired
    private DishDataBaseController dishDataBaseController;

    @RequestMapping(value = "/addDish")
    public Answer addDish(int categoryId, String name, String description, String price) {
        if(dishDataBaseController.findDish(name) == null) {
            Dish dish = dishDataBaseController.addDish(categoryId, name, description, price);
            return new RegistrationAnswer(200, "OK", dish.getId());
        } else {
            return new Answer(400, "Dish already exists");
        }
    }
}
