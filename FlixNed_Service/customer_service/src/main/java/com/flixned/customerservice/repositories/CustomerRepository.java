package com.flixned.customerservice.repositories;

import com.flixned.common.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<User, Long> {

    User findCustomerByEmail(String email);
}
