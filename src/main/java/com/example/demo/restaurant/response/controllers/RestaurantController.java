package com.example.demo.restaurant.response.controllers;

import com.example.demo.restaurant.response.handlers.commands.RestaurantCommandHandler;
import com.example.demo.restaurant.response.handlers.queries.RestaurantQueryHandler;
import com.example.demo.restaurant.response.repository.RestaurantModel;
import com.example.demo.restaurant.response.ResponseRestaurant;
import com.example.demo.restaurant.response.requests.CreateRestaurantRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private RestaurantQueryHandler restaurantQueryHandler;
    private RestaurantCommandHandler restaurantCommandHandler;

    public RestaurantController(RestaurantQueryHandler restaurantQueryHandler, RestaurantCommandHandler commandhandler) {
        this.restaurantQueryHandler = restaurantQueryHandler;
        this.restaurantCommandHandler = commandhandler;

    }

    @GetMapping()
    public ResponseEntity<List<ResponseRestaurant>> getAllRestaurants() {

        List<ResponseRestaurant> response = restaurantQueryHandler.fetchAllRestaurants().stream()
                .map(elt -> new ResponseRestaurant(
                        String.valueOf(elt.getId()),
                        elt.getName()
                ))
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseRestaurant> getOneRestaurant(@PathVariable String id) {

        RestaurantModel responseRepo = restaurantQueryHandler.fetchRestaurant(id);

        ResponseRestaurant response = new ResponseRestaurant(
                String.valueOf(responseRepo.getId()),
                responseRepo.getName()
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public void addRestaurant(@RequestBody CreateRestaurantRequest request) {
        restaurantCommandHandler.createRestaurant(request.getName());
    }
}
