package com.flixned.customerservice.controllers;

import com.flixned.customerservice.common.models.User;
import com.flixned.customerservice.repositories.CustomerRepository;
import com.flixned.customerservice.repositories.UserRepository;
import org.springframework.context.annotation.Conditional;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = RestURIConstant.getUserByEmail, method = RequestMethod.GET)
    public @ResponseBody
    User getUserByEmail(@RequestParam("email") String email) {
        return userRepository.findUserByEmail(email);
    }

    @RequestMapping(value = RestURIConstant.current, method = RequestMethod.GET)
    public @ResponseBody
    User current() {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final String email = (String) auth.getPrincipal();
        return userRepository.findUserByEmail(email);
    }

}
