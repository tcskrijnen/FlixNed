package com.flixned.customerservice;

import com.flixned.customerservice.common.models.Customer;
import com.flixned.customerservice.common.models.User;
import com.flixned.customerservice.repositories.CustomerRepository;
import com.flixned.customerservice.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.flixned.customerservice.common.security.UserRole.ADMIN;


@EnableEurekaClient
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, RepositoryRestMvcAutoConfiguration.class})
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomerServiceApplication {
    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {

            User user = new Customer("12343245","test@test.com",passwordEncoder.encode("12345"), true, true, true, true, ADMIN.getGrantedAuthorities());

            userRepository.save(user);
        };
    }
}
