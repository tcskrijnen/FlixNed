package com.flixned.contentservice;

import com.flixned.contentservice.common.models.Movie;
import com.flixned.contentservice.common.models.Serie;
import com.flixned.contentservice.repositories.MovieRepository;
import com.flixned.contentservice.repositories.SerieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.util.ArrayList;
import java.util.List;

@EnableEurekaClient
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ContentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(MovieRepository movieRepository, SerieRepository serieRepository) {
        return args -> {

            List<String> cast1 = new ArrayList<>();
            cast1.add("test");
            cast1.add("naam");

            Movie movie1 = new Movie("test", 3000L, cast1, 2019);

            List<String> cast2 = new ArrayList<>();
            cast2.add("test");
            cast2.add("naam");

            Serie serie1 = new Serie("test", 1, 3, 2019, 3000L, cast2);

            movieRepository.save(movie1);
            serieRepository.save(serie1);
        };
    }
}
