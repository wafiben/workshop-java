package com.example.demo.restaurant.response.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RestaurantRepository {

    private final JdbcTemplate jdbcTemplate;

    public RestaurantRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<RestaurantModel> findAllRestaurants() {
        String sql = "SELECT id, name FROM restaurant";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new RestaurantModel(
                        rs.getLong("id"),
                        rs.getString("name")
                )
        );
    }

    public Optional<RestaurantModel> fetchOneRestaurantRestaurant(Long id) {

        String sql = "SELECT id, name FROM restaurant WHERE id = ?";

        List<RestaurantModel> results = jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new RestaurantModel(
                        rs.getLong("id"),
                        rs.getString("name")
                ),
                id
        );

        return results.stream().findFirst();
    }

    public void saveRestaurant(String name) {
        String sql = "INSERT INTO restaurant (name) VALUES (?)";
        jdbcTemplate.update(sql, name);
    }
}
