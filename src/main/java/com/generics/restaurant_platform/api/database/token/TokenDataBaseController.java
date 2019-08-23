package com.generics.restaurant_platform.api.database.token;

import com.generics.restaurant_platform.api.entities.Token;
import com.generics.restaurant_platform.api.user_types.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@DependsOn("tokenTable")
public class TokenDataBaseController {

    @Autowired
    private TokenTable tokenTable;

    public List<Token> findAll() {
        return new ArrayList<>(tokenTable.findAll());
    }

    public List<Token> findByUserType(UserType userType) {
        return new ArrayList<>(tokenTable.findByUserType(userType));
    }

    public Token findByToken(String token) {
        return tokenTable.findByToken(token);
    }

    public void addToken(Token token) {
        tokenTable.save(token);
    }
}
