package com.example.demo;

import com.example.demo.product.Database;
import com.example.demo.product.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
        var id = "sss";
        var price = 454;
        var product = new Product(id, price);
        System.out.println(product.toString());
        var database = new Database();
        database.saveProduct(product);
        var length = database.getLength();
        System.out.println("sssss " + length);

        database.deleteProduct(id);

        System.out.println(database.getLength());
    }
}
