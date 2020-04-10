package com.flixned.auth;

import com.flixned.common.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


        if (email.isEmpty()){
            throw new IllegalArgumentException("email can't be empty");
        }
            User user = restTemplate.getForObject("http://customer-service/user/getUserByEmail?email="+ email, User.class);

            //System.out.println(user.getUsername());
            return user;
    }
}
