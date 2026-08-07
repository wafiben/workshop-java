package com.example.demo.classes.messagecommunication.database;

import com.example.demo.classes.messagecommunication.classes.Msg;
import com.example.demo.classes.messagecommunication.interfaces.MessageRepo;

import java.util.ArrayList;
import java.util.List;

public class DatabseMessage implements MessageRepo {

    private final List<Msg> messages = new ArrayList<>();

    @Override
    public void saveMessage(Msg message) {
        messages.add(message);
    }

    public List<Msg> getMessages() {
        return messages;
    }
}