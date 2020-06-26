package com.flixned.contentservice.producers;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageProducerConfig {

    @Bean("content-service-exchange")
    public DirectExchange directExchange() {
        return new DirectExchange("content-service-exchange");
    }

    @Bean
    public MessageProducer producer() {
        return new MessageProducer();
    }
}
