package com.flixned.customerservice.controllers;

import com.flixned.customerservice.common.dto.RegisterDTO;
import com.flixned.customerservice.common.models.User;
import com.flixned.customerservice.services.CustomerService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = RestURIConstant.getCustomerByEmail, method = RequestMethod.GET)
    public @ResponseBody
    User getCustomerByEmail(@RequestParam("email") String email) {
        return customerService.getByCustomerByEmail(email);
    }

    @RequestMapping(value = RestURIConstant.getUserById, method = RequestMethod.GET)
    public @ResponseBody
    User getCustomerById(@RequestParam("userId") int userId) {
        return customerService.getByCustomerById(userId);
    }

    @RequestMapping(value = RestURIConstant.deleteCustomerById, method = RequestMethod.GET)
    public @ResponseBody
    String deleteUser(@RequestParam("userId") String userId) {
        return customerService.deleteCustomer(Integer.parseInt(userId));
    }

    @PostMapping(value = RestURIConstant.register)
    public @ResponseBody
    String customerRegister(@RequestBody String customer) {
        Gson gson = new Gson();
        var customerObject = gson.fromJson(customer, RegisterDTO.class);

        return gson.toJson(customerService.Registration(customerObject));
    }

    @RequestMapping(value = RestURIConstant.test, method = RequestMethod.GET)
    public @ResponseBody
    String test() {
        return "test";
    }
}
