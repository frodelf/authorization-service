package com.example.authorizationservice.service.impl;

import com.example.authorizationservice.entity.users.User;
import com.example.authorizationservice.jwt.JwtRequest;
import com.example.authorizationservice.jwt.JwtResponse;
import com.example.authorizationservice.jwt.JwtTokenProvider;
import com.example.authorizationservice.service.AuthorizationService;
import com.example.authorizationservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        log.info("AuthorizationServiceImpl-login start");
        JwtResponse jwtResponse = new JwtResponse();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        User user = userService.getByEmail(loginRequest.getUsername());
        jwtResponse.setAccessToken(jwtTokenProvider.createAccessToken(user.getId(), user.getEmail(), user.getRole()));
        jwtResponse.setRefreshToken(jwtTokenProvider.createRefreshToken(user.getId(), user.getEmail()));
        log.info("AuthorizationServiceImpl-login finish");
        return jwtResponse;
    }
    @Override
    public JwtResponse refresh(String refreshToken) {
        log.info("AuthorizationServiceImpl-refresh start");
        JwtResponse jwtResponse = jwtTokenProvider.refreshUserTokens(refreshToken);
        log.info("AuthorizationServiceImpl-refresh finish");
        return jwtResponse;
    }
}