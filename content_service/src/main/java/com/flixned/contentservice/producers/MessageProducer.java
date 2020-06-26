package com.flixned.contentservice.producers;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class MessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("content-service-exchange")
    @Autowired
    private DirectExchange directExchange;

    public void sendNewSerie(String message) {
        rabbitTemplate.convertAndSend(directExchange.getName(), "newSerie", message);
    }

    public void sendNewMovie(String message) {
        rabbitTemplate.convertAndSend(directExchange.getName(), "newMovie", message);
    }

}
