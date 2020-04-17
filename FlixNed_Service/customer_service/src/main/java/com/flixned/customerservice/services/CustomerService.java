package com.flixned.customerservice.services;

import com.flixned.customerservice.common.models.User;
import com.flixned.customerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public User getByCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }
}
