package com.flixned.streamingservice;

import com.flixned.streamingservice.common.models.Stream;
import com.flixned.streamingservice.repositories.StreamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableEurekaClient
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, RepositoryRestMvcAutoConfiguration.class})
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class StreamingServiceApplication {
    public static void main(String[] args) {

        SpringApplication.run(StreamingServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StreamRepository streamRepository) {
        return args -> {
            Stream stream = new Stream("93928301", "https://storage.googleapis.com/videocontent/vikingsS1E1.mp4");

            streamRepository.save(stream);
        };
    }
}
