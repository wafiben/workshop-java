package com.example.demo.restaurant.response.service;


import com.example.demo.restaurant.response.errors.EmptyNameRestaurantError;
import com.example.demo.restaurant.response.errors.InvalidIdRestaurantError;

import org.springframework.stereotype.Service;

@Service
public class RestaurantValidationService {

    public long throwInvalidId(String id) {
        throw new InvalidIdRestaurantError();
    }

    public long parseOrThrow(String id) {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new InvalidIdRestaurantError();
        }
    }

    public void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new EmptyNameRestaurantError();
        }
    }
}