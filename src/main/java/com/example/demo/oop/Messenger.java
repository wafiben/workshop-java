package com.example.demo.oop;

import com.example.demo.interafces.Discussion;

public class Messenger extends ChatService {
    Discussion discussion;

    public Messenger(String id, Discussion discussion) {
        super(id);
        this.discussion = discussion;
    }


    public void sendImage(String url) {
        this.discussion.sendImage(url);
    }
}
