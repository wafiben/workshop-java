package com.example.demo.classes.messagecommunication.classes.services;

import com.example.demo.classes.messagecommunication.classes.Msg;
import com.example.demo.classes.messagecommunication.database.DatabseUser;
import com.example.demo.classes.messagecommunication.interfaces.MessageRepo;

import java.util.List;

public class MessageService implements MessageRepo {

    private final MessageRepo messages;


    public MessageService(MessageRepo database) {
        this.messages = database;
    }

    @Override
    public void saveMessage(Msg message) {
        System.out.println("Logging: about to save message...");
        messages.saveMessage(message);
    }

    @Override
    public List<Msg> getMessages() {
        return messages.getMessages();
    }
}