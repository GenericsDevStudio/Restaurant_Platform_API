package com.generics.restaurant_platform.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String address;
    private String name;

    public Restaurant(String address, String name) {
        this.address = address;
        this.name = name;
    }

    public Restaurant() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Restaurant[id=%d name=%s, address=%s]", id, name, address);
    }
}
