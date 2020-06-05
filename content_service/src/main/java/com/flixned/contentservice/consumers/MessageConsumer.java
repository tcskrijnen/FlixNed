package com.flixned.contentservice.consumers;

import com.flixned.contentservice.services.PlaylistService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageConsumer {

    @Autowired
    private PlaylistService playlistService;

    @RabbitListener(queues = "#{userServiceQueue.name}")
    public void receiveRegional(String message) throws InterruptedException {
        System.out.println(message);
    }
}
