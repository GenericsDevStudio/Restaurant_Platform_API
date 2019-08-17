package com.generics.restaurant_platform.api.rest_controllers.category;

import com.generics.restaurant_platform.api.database.category.CategoryDataBaseController;
import com.generics.restaurant_platform.api.entities.Category;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.json_answers.RegistrationAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryAddingController {

    @Autowired
    private CategoryDataBaseController categoryDataBaseController;

    @RequestMapping(value = "/addCategory", method = RequestMethod.GET)
    public Answer addCategory(String name) {
        if(categoryDataBaseController.findCategory(name) == null) {
            Category category = new Category(name);
            categoryDataBaseController.addCategory(category);
            return new RegistrationAnswer(200, "OK", category.getId());
        } else {
            return new Answer(400, "Category already exists");
        }
    }
}
