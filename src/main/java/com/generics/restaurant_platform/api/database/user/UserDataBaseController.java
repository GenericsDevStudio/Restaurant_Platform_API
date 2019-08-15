package com.generics.restaurant_platform.api.sql.user;

import com.generics.restaurant_platform.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserDataBaseController {
    @Autowired
    private UserTable userTable;

    public User addUser(String fio, String email, String pass) {
        User user = new User(fio, email, pass);
        userTable.save(user);
        return user;
    }

    public Iterable<User> getAllUsers() {
        return userTable.findAll();
    }
}
