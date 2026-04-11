package com.example.demo;

import com.example.demo.classes.Admin;
import com.example.demo.classes.Client;
import com.example.demo.classes.Post;
import com.example.demo.classes.Role;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);

        Admin userAdmin = new Admin("rami", "beomrane", "rami@gmail.com", "123", Role.Admin, 31);

        var posts = new ArrayList<Post>();


        Client clientUser = new Client("rami", "beomrane", "rami@gmail.com", "123", Role.Client, posts);

        clientUser.createPost("Happy birthday");

        clientUser.deletePost(1);

        System.out.println("ssssssss " + clientUser.toString());

    }

}
