package com.example.authorizationservice.controller;

import com.example.authorizationservice.jwt.JwtRequest;
import com.example.authorizationservice.jwt.JwtResponse;
import com.example.authorizationservice.service.AuthorizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Auth controller", description = "Auth API")
public interface AuthController {
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized"),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content(mediaType = "application/json")),
    })
    @Operation(summary = "The request to login")
    JwtResponse login(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "DTO with fields for authorization") @RequestBody JwtRequest loginRequest);
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized"),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content(mediaType = "application/json")),
    })
    @Operation(summary = "The request to update access token by refresh token")
    JwtResponse refresh(@Parameter(required = true, description = "Refresh token to update the access token") @RequestHeader String refreshToken);
}