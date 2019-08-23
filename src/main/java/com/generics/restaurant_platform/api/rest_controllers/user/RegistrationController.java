package com.generics.restaurant_platform.api.rest_controllers.user;

import com.generics.restaurant_platform.api.database.token.TokenDataBaseController;
import com.generics.restaurant_platform.api.entities.Token;
import com.generics.restaurant_platform.api.entities.User;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.database.user.UserDataBaseController;
import com.generics.restaurant_platform.api.json_answers.TokenAnswer;
import com.generics.restaurant_platform.api.user_types.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
public class RegistrationController {
    @Autowired
    private UserDataBaseController userDataBaseController;

    @Autowired
    private TokenDataBaseController tokenDataBaseController;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public Answer registration(String fio, String email, String pass) {
        if(userDataBaseController.findUser(email) == null) {
            User user = new User(fio, email, pass);

            userDataBaseController.addUser(user);
            tokenDataBaseController.addToken(new Token(user.getToken(), UserType.GUEST, user.getId()));

            return new TokenAnswer(200, "OK", user.getToken());
        } else {
            return new Answer(400, "User already exists");
        }
    }


}
