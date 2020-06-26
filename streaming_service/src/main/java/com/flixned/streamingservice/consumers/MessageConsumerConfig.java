package com.flixned.streamingservice.consumers;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConsumerConfig {

    @Bean("content-service-exchange")
    public DirectExchange directExchange() {
        return new DirectExchange("content-service-exchange");

    }

    @Bean
    public Queue newSerieQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue newMovieQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding bindingNewMovieContentService(@Qualifier("content-service-exchange") DirectExchange directExchangeMovieService, Queue newMovieQueue) {
        return BindingBuilder.bind(newMovieQueue).to(directExchangeMovieService).with("newMovie");
    }

    @Bean
    public Binding bindingNewSerieContentService(@Qualifier("content-service-exchange") DirectExchange directExchangeSerieService, Queue newSerieQueue) {
        return BindingBuilder.bind(newSerieQueue).to(directExchangeSerieService).with("newSerie");
    }

    @Bean
    public MessageConsumer consumer() {
        return new MessageConsumer();
    }
}
