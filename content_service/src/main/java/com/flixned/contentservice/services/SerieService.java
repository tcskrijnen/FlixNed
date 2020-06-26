package com.flixned.contentservice.services;

import com.flixned.contentservice.common.models.Serie;
import com.flixned.contentservice.producers.MessageProducer;
import com.flixned.contentservice.repositories.SerieRepository;
import com.flixned.contentservice.utils.RandomString;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

@Service
public class SerieService {

    private final SerieRepository serieRepository;
    private final MessageProducer messageProducer;

    public SerieService(SerieRepository serieRepository, MessageProducer messageProducer) {
        this.serieRepository = serieRepository;
        this.messageProducer = messageProducer;
    }

    public Iterable<Serie> allSeries() {
        return serieRepository.findAll();
    }

    public Serie getSerieById(String serieId){
        return serieRepository.getSerieBySerieId(serieId);
    }

    public String newSerie(String serie){
        RandomString rdmStr = new RandomString();
        Gson gson = new Gson();

        Serie serieObject = gson.fromJson(serie, Serie.class);
        serieObject.setSerieId(rdmStr.getAlphaNumericString(8));

        Serie newSerie = serieRepository.save(serieObject);

        if(newSerie != null){
            messageProducer.sendNewSerie(newSerie.getSerieId());
            return "saved";
        }else {
            return "User not saved";
        }
    }
}
