package com.common.common.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "user_customer")
public class Customer extends User {

    @Column
    private String CustomerNumber;

    public Customer(String customerNumber, String email, String password_hash,
                    boolean isAccountNonExpired, boolean isEnabled, boolean isAccountNonLocked,
                    boolean isCredentialsNonExpired, Set<CustomGrantedAuthority> customGrantedAuthorities) {
        super(email, password_hash, isAccountNonExpired, isEnabled, isAccountNonLocked, isCredentialsNonExpired, customGrantedAuthorities);

        this.CustomerNumber = customerNumber;
    }

    public Customer() {  }

    public String getCustomerNumber() {
        return CustomerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.CustomerNumber = customerNumber;
    }


}
