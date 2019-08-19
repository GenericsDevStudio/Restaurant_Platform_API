package com.generics.restaurant_platform.api.services;

import com.generics.restaurant_platform.api.database.token.TokenDataBaseController;
import com.generics.restaurant_platform.api.entities.Token;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.user_types.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddRootUser {
    @Autowired
    private TokenDataBaseController tokenDataBaseController;

    @RequestMapping(value = "/addRoot", method = RequestMethod.POST)
    public Answer addRoot(String pass) {
        if(pass.equals("akjdsaipdjsaopdolxcm"))
        tokenDataBaseController.addToken(new Token("root", UserType.ADMIN, 1));
        return new Answer(200, "OK");
    }
}
