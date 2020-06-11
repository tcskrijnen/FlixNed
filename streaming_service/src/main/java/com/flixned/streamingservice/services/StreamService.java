package com.flixned.streamingservice.services;

import com.flixned.streamingservice.common.models.Stream;
import com.flixned.streamingservice.repositories.StreamRepository;
import org.springframework.stereotype.Service;

@Service
public class StreamService {

    private final StreamRepository streamRepository;

    public StreamService(StreamRepository streamRepository) {
        this.streamRepository = streamRepository;
    }

    public Iterable<Stream> allStreams() {
        return streamRepository.findAll();
    }

    public Stream getStream(String contentId) {
        return streamRepository.getStreamByContentId(contentId);
    }
}
