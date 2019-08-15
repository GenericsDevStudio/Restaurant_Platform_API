package com.generics.restaurant_platform.api.sql.user;

import com.generics.restaurant_platform.api.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserTable extends CrudRepository<User, Integer> {
}
