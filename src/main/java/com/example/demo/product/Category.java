package com.example.demo.product;

public class Category {
    private String id;
    private CategoryName nameOfCategory;

    public Category(String id, CategoryName nameOfCategory) {
        this.id = id;
        this.nameOfCategory = nameOfCategory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CategoryName getNameOfCategory() {
        return nameOfCategory;
    }

    public void setNameOfCategory(CategoryName nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }
}
