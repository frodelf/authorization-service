package com.example.authorizationservice.controller.impl;

import com.example.authorizationservice.controller.AuthController;
import com.example.authorizationservice.jwt.JwtRequest;
import com.example.authorizationservice.jwt.JwtResponse;
import com.example.authorizationservice.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {
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