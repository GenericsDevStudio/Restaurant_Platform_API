package com.generics.restaurant_platform.api.database.user;

import com.generics.restaurant_platform.api.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserTable extends CrudRepository<User, Integer> {
    User findByEmail(String email);
    List<User> findAll();
}
