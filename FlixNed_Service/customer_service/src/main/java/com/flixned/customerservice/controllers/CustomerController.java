package com.flixned.customerservice.controllers;

import com.flixned.customerservice.common.models.User;
import com.flixned.customerservice.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = RestURIConstant.getUserByEmail, method = RequestMethod.GET)
    public @ResponseBody
    User getCustomerByEmail(@RequestParam("email") String email) {
        return customerService.getByCustomerByEmail(email);
    }

    @RequestMapping(value = RestURIConstant.test, method = RequestMethod.GET)
    public @ResponseBody
    String test() {
        return "test";
    }
}
