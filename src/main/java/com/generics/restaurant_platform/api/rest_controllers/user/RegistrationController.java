package com.generics.restaurant_platform.api.rest_controllers.user;

import com.generics.restaurant_platform.api.entities.User;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.json_answers.RegistrationAnswer;
import com.generics.restaurant_platform.api.database.user.UserDataBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private UserDataBaseController userDataBaseController;

    //TODO request method = post
    @RequestMapping(value = "/registration")
    public Answer registration(String fio, String email, String pass) {
        if(userDataBaseController.findUser(email) == null) {
            User user = userDataBaseController.addUser(fio, email, pass);
            return new RegistrationAnswer(200, "OK", user.getId());
        } else {
            return new Answer(400, "User already exists");
        }
    }


}
