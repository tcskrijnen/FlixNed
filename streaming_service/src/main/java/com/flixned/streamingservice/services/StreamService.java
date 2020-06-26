package com.flixned.streamingservice.services;

import com.flixned.streamingservice.common.models.Stream;
import com.flixned.streamingservice.repositories.StreamRepository;
import com.google.gson.Gson;
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

    public void saveSerie(String serie){
        Gson gson = new Gson();

        Stream streamObject = gson.fromJson(serie, Stream.class);
        streamRepository.save(streamObject);
    }

    public void saveMovie(String movie){
        Gson gson = new Gson();

        Stream streamObject = gson.fromJson(movie, Stream.class);
        streamRepository.save(streamObject);
    }
}
