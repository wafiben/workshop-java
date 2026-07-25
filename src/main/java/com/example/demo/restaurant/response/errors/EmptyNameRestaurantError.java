package com.example.demo.restaurant.response.errors;

import org.springframework.http.HttpStatus;

public class EmptyNameRestaurantError extends BaseError {

    public EmptyNameRestaurantError() {
        super("NAME_SHOULD_NOT_BE_EMPTY",
                HttpStatus.BAD_REQUEST);
    }
}
