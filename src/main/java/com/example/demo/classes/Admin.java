package com.example.demo.classes;

public class Admin extends User {
    private Integer age;

    public Admin(String firstName, String lastName, String email, String password, Role role, Integer age) {
        super(firstName, lastName, email, password,role);
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
