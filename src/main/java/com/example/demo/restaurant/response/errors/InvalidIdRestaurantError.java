package com.example.demo.restaurant.response.errors;

import org.springframework.http.HttpStatus;

public class InvalidIdRestaurantError extends BaseError {

    public InvalidIdRestaurantError() {
        super("ID_IS_NOT_VALID",
                HttpStatus.BAD_REQUEST);
    }
}