package com.generics.restaurant_platform.api.rest_controllers;

import com.generics.restaurant_platform.api.json_answers.Answer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Answer login(String email, String pass) {
        //TODO check with database
        return new Answer(200);
    }
}
