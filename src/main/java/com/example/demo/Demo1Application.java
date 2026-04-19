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
        S3 stockage = new S3();
        stockage.upload("file.txt", "Hello java algorithms");
        stockage.viziliseStorage();
        var id = "sss";
//        lancer le protoclo http;
//        Http http = new Http();
//        ouvrir messenger

        Messenger messenger = new Messenger(id);
        messenger.sendImage("hhtp/profile/rami");
        //viziliseStorage
    }

}
