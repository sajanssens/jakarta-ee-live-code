package com.infosupport.producers;

import jakarta.annotation.Resource;
import jakarta.ejb.Schedule;
import jakarta.ejb.Stateless;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSProducer;
import jakarta.jms.Queue;

import java.time.LocalDateTime;

@Stateless
public class AangifteProducer {

    @Resource(name = "jms/aangiftesQueue")
    private Queue queue;

    @Resource(name = "jms/connectionFactory")
    private ConnectionFactory connectionFactory;

    @Schedule(hour = "*", minute = "*", second = "*/1", persistent = false)
    public void send() {
        AangifteDto dto = new AangifteDto(LocalDateTime.now().toString());
        System.out.println("About to send message: " + dto);
        try (var context = connectionFactory.createContext()) {
            JMSProducer producer = context.createProducer();
            producer.send(queue, dto.toString());
        }
    }
}
