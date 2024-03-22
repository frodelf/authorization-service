package com.example.authorizationservice.entity.users;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Builder extends User {
    @ElementCollection
    private List<Long> buildings;
}