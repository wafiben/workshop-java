package com.example.demo.product;

import java.util.ArrayList;
import java.util.List;

public class Database {
    List<Product> products = new ArrayList<>();

    List<Category> categories = new ArrayList<>();

    public void saveProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(String id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    private void saveProduct(Category category) {
        categories.add(category);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Integer getLength() {
        return products.size();
    }
}