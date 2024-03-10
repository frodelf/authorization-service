package com.example.authorizationservice.jwt;

import lombok.Data;

@Data
public class JwtResponse {
    private String accessToken;
    private String refreshToken;
}
