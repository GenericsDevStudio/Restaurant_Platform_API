package com.generics.restaurant_platform.api.rest_controllers.category;

import com.generics.restaurant_platform.api.database.category.CategoryDataBaseController;
import com.generics.restaurant_platform.api.entities.Category;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.json_answers.RegistrationAnswer;
import com.generics.restaurant_platform.api.services.CheckPermission;
import com.generics.restaurant_platform.api.user_types.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;

@RestController
public class CategoryAddingController {
    @Autowired
    private CategoryDataBaseController categoryDataBaseController;

    @Autowired
    private CheckPermission checkPermission;

    @Resource(name = "addCategoryConfig")
    private HashSet<UserType> userTypes;

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public Answer addCategory(String token, String name) {
        if(userTypes.contains(checkPermission.checkPermisson(token))) {
            if (categoryDataBaseController.findCategory(name) == null) {
                Category category = new Category(name);
                categoryDataBaseController.addCategory(category);
                return new RegistrationAnswer(200, "OK", category.getId());
            } else {
                return new Answer(400, "Category already exists");
            }
        } else {
            return new Answer(403, "Permission denied");
        }
    }
}
