package com.flixned.contentservice;

import com.flixned.contentservice.common.models.Movie;
import com.flixned.contentservice.repositories.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableEurekaClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ContentServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(ContentServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ContentRepository contentRepository) {
        return args -> {

        };
    }
}
