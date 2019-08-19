package com.generics.restaurant_platform.api.entities;

import com.generics.restaurant_platform.api.user_types.UserType;

import javax.persistence.*;

@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String token;

    private UserType userType;

    private int userId;

    public Token(String token, UserType userType, int userId) {
        this.token = token;
        this.userType = userType;
        this.userId = userId;
    }

    public Token() {}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
