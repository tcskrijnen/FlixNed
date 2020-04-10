package com.flixned.customerservice;

import com.flixned.common.models.User;
import com.flixned.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.flixned.common.security.UserRole.ADMIN;

@EnableEurekaClient
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, RepositoryRestMvcAutoConfiguration.class})
@ComponentScan({"com.flixned.common", "com.flixned.customerservice"})
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomerServiceApplication {
    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        return args -> {

            User user = new User(passwordEncoder.encode("12345"),"test@test.com", true, true, true, true, ADMIN.getGrantedAuthorities());

            customerRepository.save(user);
        };
    }
}
