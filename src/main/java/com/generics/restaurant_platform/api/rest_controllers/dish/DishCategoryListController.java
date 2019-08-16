package com.generics.restaurant_platform.api.rest_controllers.dish;

import com.generics.restaurant_platform.api.database.dish.DishDataBaseController;
import com.generics.restaurant_platform.api.entities.Dish;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.json_answers.ListAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishCategoryListController {

    @Autowired
    private DishDataBaseController dishDataBaseController;

    @RequestMapping(value = "/getDishesInCategory")
    public Answer getDishesInCategory(int categoryId) {
        return new ListAnswer<Dish>(200, "OK", dishDataBaseController.getAllDishesByCategory(categoryId));
    }
}
