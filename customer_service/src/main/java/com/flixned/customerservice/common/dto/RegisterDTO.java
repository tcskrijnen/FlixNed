package com.flixned.customerservice.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterDTO {

    @JsonProperty
    private String email;

    @JsonProperty
    private String password;

    public RegisterDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public RegisterDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
