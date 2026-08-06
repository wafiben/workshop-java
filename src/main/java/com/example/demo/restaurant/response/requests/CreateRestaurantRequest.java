package com.example.demo.restaurant.response.requests;

public class CreateRestaurantRequest {
    private String name;

    public CreateRestaurantRequest() {
    }

    public CreateRestaurantRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
