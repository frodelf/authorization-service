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
        log.info("UserServiceImpl-getById start");
        User user = userRepository.findById(userId).orElseThrow(
                () -> {
                    log.error("User with id={} not found", userId);
                    return new EntityNotFoundException("User with id=" + userId + " not found");
                }
        );
        log.info("UserServiceImpl-getById finish");
        return user;
    }
    @Override
    public User getByEmail(String email) {
        log.info("UserServiceImpl-getByEmail start");
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> {
                    log.error("User with email={} not found", email);
                    return new EntityNotFoundException("User with email=" + email + " not found");
                }
        );
        log.info("UserServiceImpl-getByEmail finish");
        return user;
    }
}
