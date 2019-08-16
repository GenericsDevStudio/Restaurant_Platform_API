package com.generics.restaurant_platform.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String fio;
    private String email;
    private String pass;

    public User() {

    }

    public User(String fio, String email, String pass) {
        this.fio = fio;
        this.email = email;
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d fio=%s, email=%s, pass=%s]", id, fio, email, pass);
    }
}
