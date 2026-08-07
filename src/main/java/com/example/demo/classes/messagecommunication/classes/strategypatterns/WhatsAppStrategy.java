package com.example.demo.classes.messagecommunication.classes.strategypatterns;

import com.example.demo.classes.messagecommunication.classes.Msg;
import com.example.demo.classes.messagecommunication.interfaces.StartegyMessage;

public class WhatsAppStrategy implements StartegyMessage {
    @Override
    public void sendMessage(Msg notification) {
        System.out.println("WHATSUP");
    }
}