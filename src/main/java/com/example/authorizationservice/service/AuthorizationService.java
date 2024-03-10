package com.example.authorizationservice.service;

import com.example.authorizationservice.jwt.JwtRequest;
import com.example.authorizationservice.jwt.JwtResponse;

public interface AuthorizationService {
    JwtResponse login(JwtRequest loginRequest);
    JwtResponse refresh(String refreshToken);
}