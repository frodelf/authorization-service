package com.example.authorizationservice.service;

import com.example.authorizationservice.entity.users.User;

public interface UserService {
    User getById(Long userId);

    User getByEmail(String email);
}
