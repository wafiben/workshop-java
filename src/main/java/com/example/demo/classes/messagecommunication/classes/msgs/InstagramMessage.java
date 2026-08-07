package com.example.demo.classes.messagecommunication.classes.msgs;

import com.example.demo.classes.messagecommunication.classes.CommunicationType;
import com.example.demo.classes.messagecommunication.classes.Msg;
import com.example.demo.classes.user.User;

public class InstagramMessage extends Msg {

    public InstagramMessage(String content, User from, User to) {
        super(content, from, to);
    }

    public CommunicationType getType() {
        return CommunicationType.INSTAGRAM;
    }
}
