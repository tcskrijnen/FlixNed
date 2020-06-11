package com.flixned.contentservice.consumers;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConsumerConfig {

    @Bean("user-service-exchange")
    public DirectExchange directExchange() {
        return new DirectExchange("user-service-exchange");

    }

    @Bean
    public Queue userServiceQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding bindingUserService(@Qualifier("user-service-exchange") DirectExchange directExchangeSimulator, Queue userServiceQueue) {
        return BindingBuilder.bind(userServiceQueue).to(directExchangeSimulator).with("message");
    }

    @Bean
    public MessageConsumer consumer() {
        return new MessageConsumer();
    }
}
