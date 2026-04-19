package com.example.demo.oop;


public class ChatService {
    private String id;

    public ChatService(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private void chat() {
        var chatInfo = "chat with someone";
    }
}

// 1-encapsulation
//avoir des getter et des setters
//class -les instances


