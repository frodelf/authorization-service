package com.example.authorizationservice.service.client;

import com.example.authorizationservice.entity.Role;
import com.example.authorizationservice.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.LinkedHashMap;
import java.util.Map;

@Log4j2
public class UserService {
    private final static String URL = "http://user-service:47076/api/v1/user";
    public static User getById(Long userId) {
        log.info("UserService-getById start");
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL + "/get-by-id/"+userId);
        ResponseEntity<User> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, User.class);
        log.info("UserService-getById finish");
        return response.getBody();
    }
    public static User getByEmail(String email) {
        log.info("UserService-getById start");
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL + "/get-by-email/"+email);
        ResponseEntity<Object> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> responseMap = objectMapper.convertValue(response.getBody(), Map.class);
        User user = new User();
        Integer id = (Integer)responseMap.get("id");
        user.setId(id.longValue());
        user.setName(String.valueOf(responseMap.get("name")));
        user.setEmail(String.valueOf(responseMap.get("email")));
        user.setPassword(String.valueOf(responseMap.get("password")));
        LinkedHashMap<String, Object> roleMap = (LinkedHashMap<String, Object>) responseMap.get("role");
        user.setRole(new Role(((Integer)roleMap.get("id")).longValue(), (String)roleMap.get("name")));
        log.info("UserService-getById finish");
        return user;
    }
}
