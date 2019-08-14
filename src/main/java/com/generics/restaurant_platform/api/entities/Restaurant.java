package com.generics.restaurant_platform.api.entities;

public class Restaurant {
    private String address;
    private String name;

    public Restaurant(String address, String name) {
        this.address = address;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }
}
