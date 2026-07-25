package com.example.demo.restaurant.response.handlers.queries;

import com.example.demo.restaurant.response.errors.NotFoundRestaurant;
import com.example.demo.restaurant.response.repository.RestaurantModel;
import com.example.demo.restaurant.response.repository.RestaurantRepository;
import com.example.demo.restaurant.response.service.RestaurantValidationService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantQueryHandler {

    private RestaurantRepository restaurantRepository;
    private RestaurantValidationService validationService;

    public RestaurantQueryHandler(RestaurantRepository restaurantRepository,
                                  RestaurantValidationService validationService) {
        this.restaurantRepository = restaurantRepository;
        this.validationService = validationService;
    }


    public RestaurantModel fetchRestaurant(String id) {
        long longId = (id == null || id.isBlank())
                ? validationService.throwInvalidId(id)
                : validationService.parseOrThrow(id);

        return restaurantRepository.fetchOneRestaurantRestaurant(longId)
                .orElseThrow(NotFoundRestaurant::new);
    }

    public List<RestaurantModel> fetchAllRestaurants() {
        return restaurantRepository.findAllRestaurants();
    }
}
