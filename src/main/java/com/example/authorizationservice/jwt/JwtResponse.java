package com.example.authorizationservice.jwt;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO for response that contains access and update tokens")
public class JwtResponse {
    private String accessToken;
    private String refreshToken;
}