package com.example.demo.restaurant.response.errors;

import org.springframework.http.HttpStatus;

public class NotFoundRestaurant extends BaseError {

    public NotFoundRestaurant() {
        super("RESTAURANT_IS_NOT_FOUND",
                HttpStatus.NOT_FOUND);
    }
}