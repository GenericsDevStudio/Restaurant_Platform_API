package com.generics.restaurant_platform.api.rest_controllers.user;


import com.generics.restaurant_platform.api.database.user.UserDataBaseController;
import com.generics.restaurant_platform.api.entities.User;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.json_answers.ListAnswer;
import com.generics.restaurant_platform.api.services.CheckPermission;
import com.generics.restaurant_platform.api.user_types.UserType;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;

@RestController
public class UserListController {

    @Autowired
    private UserDataBaseController userDataBaseController;

    @Autowired
    private CheckPermission checkPermission;

    @Resource(name = "getUserConfig")
    private HashSet<UserType> userTypes;

    @RequestMapping(value = "/getUsers", method = RequestMethod.POST)
    public Answer getUsers(String token) {
        if(userTypes.contains(checkPermission.checkPermisson(token))) {
            return new ListAnswer<User>(200, "OK", userDataBaseController.getAllUsers());
        } else {
            return new Answer(403, "Permission denied");
        }
    }
}
