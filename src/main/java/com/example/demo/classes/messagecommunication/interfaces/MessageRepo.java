package com.example.demo.classes.messagecommunication.interfaces;

import com.example.demo.classes.messagecommunication.classes.Msg;

import java.util.List;

public interface MessageRepo {
    void saveMessage(Msg message);

    List<Msg> getMessages();

}