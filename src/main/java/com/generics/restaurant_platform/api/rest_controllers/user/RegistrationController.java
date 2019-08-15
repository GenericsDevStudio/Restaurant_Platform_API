package com.generics.restaurant_platform.api.rest_controllers;

import com.generics.restaurant_platform.api.entities.User;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.json_answers.RegistrationAnswer;
import com.generics.restaurant_platform.api.sql.user.UserDataBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private UserDataBaseController userDataBaseController;

    @RequestMapping(value = "/registration")
    public Answer registration(String fio, String email, String pass) {
        User user = userDataBaseController.addUser(fio, email, pass);
        return new RegistrationAnswer(200, user.getId());
    }


}
