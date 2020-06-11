package com.flixned.customerservice.producers;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageProducerConfig {

    @Bean("user-service-exchange")
    public DirectExchange directExchange() {
        return new DirectExchange("user-service-exchange");
    }

    @Bean
    public MessageProducer producer() {
        return new MessageProducer();
    }
}
