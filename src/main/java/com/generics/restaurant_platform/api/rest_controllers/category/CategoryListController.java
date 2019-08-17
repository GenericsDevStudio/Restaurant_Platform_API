package com.generics.restaurant_platform.api.rest_controllers.category;

import com.generics.restaurant_platform.api.database.category.CategoryDataBaseController;
import com.generics.restaurant_platform.api.entities.Category;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.json_answers.ListAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryListController {

    @Autowired
    private CategoryDataBaseController categoryDataBaseController;

    @RequestMapping(value = "/categoryList", method = RequestMethod.GET)
    public Answer getCategoryList() {
        List<Category> list = categoryDataBaseController.getAllCategories();
        return new ListAnswer<Category>(200, "OK", list);
    }
}
