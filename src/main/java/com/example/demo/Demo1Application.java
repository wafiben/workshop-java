package com.example.demo;

import com.example.demo.oop.Messenger;
import com.example.demo.protocols.Http;
import com.example.demo.protocols.sendimages.S3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
}
