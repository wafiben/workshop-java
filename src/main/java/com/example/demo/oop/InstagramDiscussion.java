package com.example.demo.oop;

import com.example.demo.interafces.Discussion;

public class InstagramDiscussion extends ChatService {
    Discussion discussion;

    public InstagramDiscussion(String id, Discussion discussion) {
        super(id);
        this.discussion = discussion;
    }

    private void chat() {
        var chatInfo = "chat using instagram";
    }


    public void sendImage(String url) {
        this.discussion.sendImage(url);
    }
}


//Heritage :
//avoir une classe mere et une classe fille
//polymorphsism : avoit des methode avec de diffrent comportement ;


//Abstarction <===>(interface)