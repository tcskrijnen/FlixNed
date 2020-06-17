package com.flixned.customerservice.repositories;

import com.flixned.customerservice.common.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findCustomerByEmail(String email);
    Customer findCustomerById(Long userId);
}
