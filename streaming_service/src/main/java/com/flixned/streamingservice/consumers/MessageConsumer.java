package com.flixned.streamingservice.consumers;

import com.flixned.streamingservice.services.StreamService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageConsumer {

    @Autowired
    private StreamService streamService;

    @RabbitListener(queues = "#{newSerieQueue.name}")
    public void receiveSerie(String message) throws InterruptedException {
        streamService.saveSerie(message);
        System.out.println(message);
    }

    @RabbitListener(queues = "#{newMovieQueue.name}")
    public void receiveMovie(String message) throws InterruptedException {
        streamService.saveMovie(message);
        System.out.println(message);
    }

}
