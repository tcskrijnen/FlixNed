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
    public Queue registerQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue deleteQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding bindingRegisterUserService(@Qualifier("user-service-exchange") DirectExchange directExchangeUserService, Queue registerQueue) {
        return BindingBuilder.bind(registerQueue).to(directExchangeUserService).with("register");
    }

    @Bean
    public Binding bindingDeleteUserService(@Qualifier("user-service-exchange") DirectExchange directExchangeUserService, Queue deleteQueue) {
        return BindingBuilder.bind(deleteQueue).to(directExchangeUserService).with("delete");
    }

    @Bean
    public MessageConsumer consumer() {
        return new MessageConsumer();
    }
}
