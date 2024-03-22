package com.example.authorizationservice.entity.users;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Notary extends User {
    @ElementCollection
    private List<Long> flat;
    @ManyToMany(mappedBy = "notaries")
    private List<Consumer> consumer;
}