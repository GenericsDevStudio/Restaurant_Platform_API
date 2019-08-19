package com.generics.restaurant_platform.api.services;

import com.generics.restaurant_platform.api.database.token.TokenDataBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("getIdByToken")
public class GetIdByToken {
    @Autowired
    private TokenDataBaseController tokenDataBaseController;

    public int getId(String token) {
        return  tokenDataBaseController.findByToken(token).getUserId();
    }
}
