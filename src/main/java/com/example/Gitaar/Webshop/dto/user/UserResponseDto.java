package com.example.Gitaar.Webshop.dto.user;

import lombok.Data;

import java.util.Set;

@Data
public class UserResponseDto {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String city;
    private String address;
    private String phoneNumber;
    private String postIndex;
    private String provider;
    private boolean active;
    private String activationCode;
    private String passwordResetCode;
    private Set<Role> roles;
}
