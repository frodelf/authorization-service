package com.example.authorizationservice.jwt;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO for request that contains username and password")
public class JwtRequest {
    @Schema(defaultValue = "admin", description = "Username for authorization")
    private String username;
    @Schema(defaultValue = "admin@gmail.com", description = "Password for authorization")
    private String password;
}