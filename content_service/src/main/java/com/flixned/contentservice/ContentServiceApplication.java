package com.flixned.contentservice;

import com.flixned.contentservice.common.models.Movie;
import com.flixned.contentservice.common.models.Playlist;
import com.flixned.contentservice.common.models.Serie;
import com.flixned.contentservice.repositories.MovieRepository;
import com.flixned.contentservice.repositories.PlaylistRepository;
import com.flixned.contentservice.repositories.SerieRepository;
import com.flixned.contentservice.utils.RandomString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EnableEurekaClient
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, RepositoryRestMvcAutoConfiguration.class})
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ContentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(MovieRepository movieRepository, SerieRepository serieRepository, PlaylistRepository playlistRepository) {
        return args -> {

            RandomString rdStr = new RandomString();

            List<String> cast1 = new ArrayList<>();
            cast1.add("test");
            cast1.add("naam");

            Movie movie1 = new Movie("43987927", "test", "test", 3000L, cast1, 2019, "");
            Movie movie2 = new Movie("82932834", "test2","test", 2000L, cast1, 2018, "");
            Movie movie3 = new Movie("94384830", "test3","test", 2000L, cast1, 2015, "");

            List<String> cast2 = new ArrayList<>();
            cast2.add("test");
            cast2.add("naam");

            Serie serie1 = new Serie("93928301","test", "testdescription", "episode name", 1, 1, 2019, 3000L, cast2, "https://storage.googleapis.com/contentimages/vikings.jpg");

            movieRepository.save(movie1);
            movieRepository.save(movie2);
            movieRepository.save(movie3);
            serieRepository.save(serie1);

            Set<String> movieSet = new HashSet();;
            Set<String> serieSet = new HashSet();;

            Playlist playlist = new Playlist(1, movieSet, serieSet);

            playlistRepository.save(playlist);
        };
    }
}
