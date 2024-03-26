package com.example.authorizationservice.entity;

import com.example.authorizationservice.entity.enums.StatusUser;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String image;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String password;
    private StatusUser status;
    private Role role;
}