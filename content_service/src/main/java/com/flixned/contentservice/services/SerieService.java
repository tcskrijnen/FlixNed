package com.flixned.contentservice.services;

import com.flixned.contentservice.common.models.Serie;
import com.flixned.contentservice.repositories.SerieRepository;
import org.springframework.stereotype.Service;

@Service
public class SerieService {

    private final SerieRepository serieRepository;

    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public Iterable<Serie> allSeries() {
        return serieRepository.findAll();
    }
}
