package com.example.demo.restaurant.response.handlers.commands;

import com.example.demo.restaurant.response.repository.RestaurantRepository;
import com.example.demo.restaurant.response.service.RestaurantValidationService;
import org.springframework.stereotype.Component;

@Component
public class RestaurantCommandHandler {
    private RestaurantRepository restaurantRepository;

    private RestaurantValidationService commandHandler;

    public RestaurantCommandHandler(RestaurantRepository restaurantRepository,
                                    RestaurantValidationService commandHandler) {
        this.restaurantRepository = restaurantRepository;
        this.commandHandler = commandHandler;
    }

    public void createRestaurant(String name) {
        this.commandHandler.validateName(name);
        restaurantRepository.saveRestaurant(name);
    }
}
