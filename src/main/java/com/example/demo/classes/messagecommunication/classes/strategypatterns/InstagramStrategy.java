package com.example.demo.classes.messagecommunication.classes.strategypatterns;

import com.example.demo.classes.messagecommunication.classes.Msg;
import com.example.demo.classes.messagecommunication.classes.services.MessageService;
import com.example.demo.classes.messagecommunication.interfaces.MessageRepo;
import com.example.demo.classes.messagecommunication.interfaces.StartegyMessage;

public class InstagramStrategy implements StartegyMessage {
    private final MessageService messageService;

    public InstagramStrategy(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void sendMessage(Msg message) {
        System.out.println("Instagram");
        messageService.saveMessage(message);
    }
}
