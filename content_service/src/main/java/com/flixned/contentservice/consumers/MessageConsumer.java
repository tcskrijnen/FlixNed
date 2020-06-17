package com.flixned.contentservice.consumers;

import com.flixned.contentservice.services.PlaylistService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageConsumer {

    @Autowired
    private PlaylistService playlistService;

    @RabbitListener(queues = "#{registerQueue.name}")
    public void receivePlaylist(String message) throws InterruptedException {
        int userId = Integer.parseInt(message);
        playlistService.createPlaylist(userId);
        System.out.println(message);
    }

    @RabbitListener(queues = "#{deleteQueue.name}")
    public void deleteQueue(String message) throws InterruptedException {
        int userId = Integer.parseInt(message);
        playlistService.deletePlaylist(userId);
        System.out.println(message);
    }
}
