package com.example.demo.classes.messagecommunication.classes;

import com.example.demo.classes.user.User;

public abstract class Msg {
    private String id;
    private String content;
    private User from;
    private User to;

    public Msg() {
    }

    public Msg(String content, User from, User to) {
        this.content = content;
        this.from = from;
        this.to = to;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public abstract CommunicationType getType();
}