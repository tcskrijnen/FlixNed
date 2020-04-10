package com.flixned.customerservice.controllers;

import com.flixned.common.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {

    @RequestMapping(value = RestURIConstant.getUserByEmail, method = RequestMethod.GET)
    public @ResponseBody
    User getCustomerByCode(@RequestParam("email") String email) {
        //return customerService.getByCustomerCode(code);

        return null;
    }
}
