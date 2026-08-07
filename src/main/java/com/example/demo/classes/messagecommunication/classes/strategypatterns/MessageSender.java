package com.example.demo.classes.messagecommunication.classes.strategypatterns;

import com.example.demo.classes.messagecommunication.classes.CommunicationType;
import com.example.demo.classes.messagecommunication.classes.Msg;
import com.example.demo.classes.messagecommunication.classes.services.MessageService;
import com.example.demo.classes.messagecommunication.interfaces.MessageRepo;
import com.example.demo.classes.messagecommunication.interfaces.StartegyMessage;

import java.util.EnumMap;
import java.util.Map;

public class MessageSender {
    private final Map<CommunicationType, StartegyMessage> strategies = new EnumMap<>(CommunicationType.class);


    public MessageSender(MessageService messageService) {
        strategies.put(CommunicationType.INSTAGRAM, new InstagramStrategy(messageService));
        strategies.put(CommunicationType.WHATSAPP, new WhatsAppStrategy());
        strategies.put(CommunicationType.MESSENGER, new MessengerStrategy());
    }

    public Map<CommunicationType, StartegyMessage> getStrategies() {
        return strategies;
    }

    public void send(Msg message) {
        StartegyMessage strategy = strategies.get(message.getType());
        strategy.sendMessage(message);
    }
}
