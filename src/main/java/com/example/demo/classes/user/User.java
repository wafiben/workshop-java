package com.example.demo.classes.user;

import com.example.demo.classes.messagecommunication.classes.Msg;

import java.util.List;

public class User {
    private String id;
    private String username;
    private List<Msg> personalMessages;

    public User(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Msg> getPersonalMessages() {
        return personalMessages;
    }

    public void setPersonalMessages(List<Msg> personalMessages) {
        this.personalMessages = personalMessages;
    }
}