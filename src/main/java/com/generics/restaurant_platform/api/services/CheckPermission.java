package com.generics.restaurant_platform.api.services;

import com.generics.restaurant_platform.api.database.token.TokenDataBaseController;
import com.generics.restaurant_platform.api.entities.Token;
import com.generics.restaurant_platform.api.user_types.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("checkPermission")
public class CheckPermission {

    @Autowired
    private TokenDataBaseController tokenDataBaseController;

    public UserType checkPermisson(String token) {
        Token dbToken = tokenDataBaseController.findByToken(token);
        if(dbToken == null)
            return UserType.JOCKER;
        else
            return dbToken.getUserType();
    }
}
