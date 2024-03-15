package com.example.authorizationservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityFilterConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeHttpRequests(
                        auth -> {
                            auth.anyRequest().permitAll();
                        });
        return httpSecurity.build();
    }
}