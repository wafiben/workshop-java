package com.example.demo.classes.messagecommunication.classes.msgs;

import com.example.demo.classes.messagecommunication.classes.CommunicationType;
import com.example.demo.classes.messagecommunication.classes.Msg;
import com.example.demo.classes.user.User;

public class MessengerMessage extends Msg {

    public MessengerMessage(String content, User from, User to) {
        super(content, from, to);
    }

    public CommunicationType getType() {
        return CommunicationType.MESSENGER;
    }
}
