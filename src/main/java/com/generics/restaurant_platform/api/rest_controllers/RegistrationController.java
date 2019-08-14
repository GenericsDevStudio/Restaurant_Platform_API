package com.generics.restaurant_platform.api.rest_controllers;

import com.generics.restaurant_platform.api.json_answers.Answer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public Answer registration(String fio, String email, String pass) {
        //TODO adding to database
        return new Answer(200);
    }
}
