package com.example.demo;

import com.example.demo.classes.messagecommunication.classes.Msg;
import com.example.demo.classes.messagecommunication.classes.msgs.InstagramMessage;
import com.example.demo.classes.messagecommunication.classes.services.MessageService;
import com.example.demo.classes.messagecommunication.classes.strategypatterns.InstagramStrategy;
import com.example.demo.classes.messagecommunication.classes.strategypatterns.MessageSender;
import com.example.demo.classes.messagecommunication.database.DatabseMessage;
import com.example.demo.classes.messagecommunication.interfaces.MessageRepo;
import com.example.demo.classes.messagecommunication.interfaces.StartegyMessage;
import com.example.demo.classes.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@SpringBootTest
class StrategyTestSender {

    private MessageSender messageSender;

    private MessageRepo repo;

    private InstagramMessage instagramMessage;

    private User userTosend;

    private User receeiverUser;

    private MessageService messageService;


    @BeforeEach
    public void setUp() {
        userTosend = new User("1", "WAFI");
        receeiverUser = new User("2", "BEDOUR");

        repo = new DatabseMessage();              // <-- real repo, not null
        messageService = new MessageService(repo); // now wraps a real object
    }

    @Test
    void shouldSendInstagramMessageSuccessfully() {

        // 1. Data — a message with its own "nature" (type)
        Msg message = new InstagramMessage("Hello!", userTosend, receeiverUser);

        // 2. Context — knows how to route any Msg to the right Strategy
        messageSender = new MessageSender(messageService);

        // 3. Behavior — resolved automatically based on message.getType()
        messageSender.send(message);

        // 4- call the instagram class indirectly
        // 4. Call the Instagram class indirectly — verify InstagramStrategy was the one invoked
        StartegyMessage resolvedStrategy = messageSender.getStrategies().get(message.getType());
        assertInstanceOf(InstagramStrategy.class, resolvedStrategy);

        assertEquals(1, repo.getMessages().size());
    }
}
