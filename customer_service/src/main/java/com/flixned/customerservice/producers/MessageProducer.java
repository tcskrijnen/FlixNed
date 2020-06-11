package com.flixned.customerservice.producers;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class MessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("user-service-exchange")
    @Autowired
    private DirectExchange directExchange;

    public void sendRegisterMessage(String message) {
        rabbitTemplate.convertAndSend(directExchange.getName(), "message", message);
    }

}
