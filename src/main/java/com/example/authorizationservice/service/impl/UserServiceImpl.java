package com.example.authorizationservice.service.impl;

import com.example.authorizationservice.entity.users.User;
import com.example.authorizationservice.repository.UserRepository;
import com.example.authorizationservice.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> {
                    log.error("User with id={} not found", userId);
                    return new EntityNotFoundException("User with id=" + userId + " not found");
                }
        );
    }
    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> {
                    log.error("User with email={} not found", email);
                    return new EntityNotFoundException("User with email=" + email + " not found");
                }
        );    }
}
