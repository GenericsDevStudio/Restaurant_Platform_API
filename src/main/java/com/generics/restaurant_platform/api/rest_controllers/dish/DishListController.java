package com.generics.restaurant_platform.api.rest_controllers.dish;

import com.generics.restaurant_platform.api.database.dish.DishDataBaseController;
import com.generics.restaurant_platform.api.entities.Dish;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.json_answers.ListAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishListController {

    @Autowired
    private DishDataBaseController dishDataBaseController;

    @RequestMapping(value = "/getDishes", method = RequestMethod.GET)
    public Answer getDishes() {
        return new ListAnswer<Dish>(200, "OK", dishDataBaseController.getAllDishes());
    }
}
