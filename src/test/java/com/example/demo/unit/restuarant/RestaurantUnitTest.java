package com.example.demo.unit.restuarant;

import com.example.demo.restaurant.response.ResponseRestaurant;
import com.example.demo.restaurant.response.controllers.RestaurantController;
import com.example.demo.restaurant.response.errors.EmptyNameRestaurantError;
import com.example.demo.restaurant.response.errors.NotFoundRestaurant;
import com.example.demo.restaurant.response.handlers.commands.RestaurantCommandHandler;
import com.example.demo.restaurant.response.handlers.queries.RestaurantQueryHandler;
import com.example.demo.restaurant.response.repository.RestaurantModel;
import com.example.demo.restaurant.response.repository.RestaurantRepository;
import com.example.demo.restaurant.response.requests.CreateRestaurantRequest;
import com.example.demo.restaurant.response.service.RestaurantValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RestaurantUnitTest {

    @Mock
    private RestaurantRepository restaurantRepository;

    private RestaurantQueryHandler restaurantQueryHandler;
    private RestaurantController restaurantController;
    private RestaurantValidationService restaurantValidationService;
    private RestaurantCommandHandler restaurantCommandHandler;

    @BeforeEach
    void setUp() {
        restaurantValidationService = new RestaurantValidationService();
        restaurantQueryHandler = new RestaurantQueryHandler(restaurantRepository, restaurantValidationService);
        restaurantCommandHandler = new RestaurantCommandHandler(restaurantRepository, restaurantValidationService);
        restaurantController = new RestaurantController(restaurantQueryHandler, restaurantCommandHandler);
    }

    private RestaurantValidationService commandHandler;


    @Test
    void shouldGetAllRestaurantsThroughFullFlow() {
        // given
        List<RestaurantModel> mockRestaurants = List.of(
                new RestaurantModel(1L, "Le Bistro"),
                new RestaurantModel(2L, "Pasta Palace")
        );
        when(restaurantRepository.findAllRestaurants()).thenReturn(mockRestaurants);

        // when
        ResponseEntity<List<ResponseRestaurant>> response = restaurantController.getAllRestaurants();

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(2);
        assertThat(response.getBody().get(0).getName()).isEqualTo("Le Bistro");
        assertThat(response.getBody().get(1).getName()).isEqualTo("Pasta Palace");

        verify(restaurantRepository).findAllRestaurants();
    }

    @Test
    void shouldThrowErrorWhenIdNotGood() {
        // given

        // given
        List<RestaurantModel> mockRestaurants = List.of(
                new RestaurantModel(1L, "Le Bistro"),
                new RestaurantModel(2L, "Pasta Palace")
        );

        when(restaurantRepository.fetchOneRestaurantRestaurant(33L))
                .thenReturn(Optional.empty());

        // when / then
        NotFoundRestaurant exception = assertThrows(
                NotFoundRestaurant.class,
                () -> restaurantController.getOneRestaurant("33")
        );

        assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void shouldThrowErrorNameIsEmpty() {
        // given
        CreateRestaurantRequest request = new CreateRestaurantRequest("");

        // when / then
        EmptyNameRestaurantError exception = assertThrows(
                EmptyNameRestaurantError.class,
                () -> restaurantController.addRestaurant(request)
        );

        assertThat(exception.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void shouldCreateRestaurantCorrectly() {
        // given
        CreateRestaurantRequest request = new CreateRestaurantRequest("Bistro");

        // when
        assertDoesNotThrow(() -> restaurantController.addRestaurant(request));

        // then
        verify(restaurantRepository).saveRestaurant("Bistro");
    }
}
