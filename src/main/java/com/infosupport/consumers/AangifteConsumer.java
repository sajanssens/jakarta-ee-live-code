package com.infosupport.consumers;

import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@MessageDriven(name = "aangifteMdb")
public class AangifteConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            String m = message.getBody(String.class);
            System.out.println("Message received: " + m);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
