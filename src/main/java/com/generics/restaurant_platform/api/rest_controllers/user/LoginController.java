package com.generics.restaurant_platform.api.rest_controllers.user;

import com.generics.restaurant_platform.api.entities.User;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.database.user.UserDataBaseController;
import com.generics.restaurant_platform.api.json_answers.RegistrationAnswer;
import com.generics.restaurant_platform.api.json_answers.TokenAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserDataBaseController userDataBaseController;

    //TODO request method = post
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Answer login(String email, String pass) {
        User user = userDataBaseController.findUser(email);
        if(user == null) return new Answer(404, "User does not exist!");

        if(user.getPass().equals(pass)) {
            return new TokenAnswer(200, "OK", user.getToken());
        } else {
            return new Answer(400, "Wrong password!");
        }
    }
}
