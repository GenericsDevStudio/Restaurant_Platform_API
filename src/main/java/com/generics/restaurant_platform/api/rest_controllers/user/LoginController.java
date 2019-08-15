package com.generics.restaurant_platform.api.rest_controllers;

import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.sql.user.UserDataBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserDataBaseController userDataBaseController;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Answer login(String email, String pass) {
        //TODO check with database
        return new Answer(200);
    }
}
