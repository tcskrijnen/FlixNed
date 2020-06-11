package com.flixned.customerservice.services;

import com.flixned.customerservice.common.dto.RegisterDTO;
import com.flixned.customerservice.common.models.Customer;
import com.flixned.customerservice.common.models.User;
import com.flixned.customerservice.common.utils.AuthenticationUtils;
import com.flixned.customerservice.common.utils.RandomString;
import com.flixned.customerservice.exceptions.BadRequestException;
import com.flixned.customerservice.exceptions.DatabaseException;
import com.flixned.customerservice.producers.MessageProducer;
import com.flixned.customerservice.repositories.CustomerRepository;
import com.flixned.customerservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import static com.flixned.customerservice.common.security.UserRole.USER;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    private final MessageProducer messageProducer;

    public CustomerService(CustomerRepository customerRepository, UserRepository userRepository, MessageProducer messageProducer) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
        this.messageProducer = messageProducer;
    }

    public User getByCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    public String Registration(RegisterDTO register) {

        RandomString rdm = new RandomString();

        User userExist = customerRepository.findCustomerByEmail(register.getEmail());

        if(userExist == null){
            User newCustomer = new Customer(rdm.getAlphaNumericString(10), register.getEmail(), new AuthenticationUtils().encode(register.getPassword()), true, true, true, true, USER.getGrantedAuthorities());

            try{
                userRepository.save(newCustomer);

                messageProducer.sendRegisterMessage(newCustomer.getId().toString());

                return "saved";
            }catch (DatabaseException ex){
                throw new DatabaseException("customer not saved");
            }
        }
        else{
            throw new BadRequestException("customer already exist");
        }
    }

    public void test(){
        messageProducer.sendRegisterMessage("pp");
    }
}
