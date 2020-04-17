package com.flixned.customerservice.controllers;

import com.flixned.customerservice.common.models.User;
import com.flixned.customerservice.repositories.CustomerRepository;
import org.springframework.context.annotation.Conditional;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private final CustomerRepository customerRepository;

    public UserController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = RestURIConstant.current, method = RequestMethod.GET)
    public @ResponseBody
    User current() {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final String email = (String) auth.getPrincipal();
        return customerRepository.findCustomerByEmail(email);
    }
}
