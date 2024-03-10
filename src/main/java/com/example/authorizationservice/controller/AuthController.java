package com.example.authorizationservice.controller;

import com.example.authorizationservice.jwt.JwtRequest;
import com.example.authorizationservice.jwt.JwtResponse;
import com.example.authorizationservice.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthorizationService authService;
    @PostMapping("/login")
    public JwtResponse login(@RequestBody JwtRequest loginRequest){
        return authService.login(loginRequest);
    }
    @PostMapping("/refresh")
    public JwtResponse refresh(@RequestHeader String refreshToken) {
        return authService.refresh(refreshToken);
    }
}