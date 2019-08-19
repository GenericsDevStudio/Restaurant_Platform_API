package com.generics.restaurant_platform.api.database.token;

import com.generics.restaurant_platform.api.entities.Token;
import com.generics.restaurant_platform.api.user_types.UserType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TokenTable extends CrudRepository<Token, Integer> {

    List<Token> findAll();
    List<Token> findByUserType(UserType userType);
    Token findByToken(String token);
}
