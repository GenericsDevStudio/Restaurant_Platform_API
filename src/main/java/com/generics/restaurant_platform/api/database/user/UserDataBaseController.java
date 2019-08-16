package com.generics.restaurant_platform.api.database.user;

import com.generics.restaurant_platform.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserDataBaseController {
    @Autowired
    private UserTable userTable;

    public User addUser(String fio, String email, String pass) {
        User user = new User(fio, email, pass);
        userTable.save(user);
        return user;
    }

    public List<User> getAllUsers() {
        return new ArrayList(userTable.findAll());
    }

    public User findUser(String email) {
        return userTable.findByEmail(email);
    }
}
