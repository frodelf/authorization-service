package com.example.authorizationservice.entity.users;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Consumer extends User {
    private String agentName;
    private String agentSurname;
    private String agentPhone;
    private String agentEmail;
    private LocalDate subscriptionValidUntil;
    private Boolean onlyMe;
    private Boolean meAndAgent;
    private Boolean onlyAgent;
    private Boolean exclude;
    @ManyToMany
    @JoinTable(
            name = "notary_consumer",
            joinColumns = @JoinColumn(name = "notary_id"),
            inverseJoinColumns = @JoinColumn(name = "consumer_id"))
    private List<Notary> notaries;
    @ElementCollection
    private List<Long> likeBuildings;
    @ElementCollection
    private List<Long> likeFlats;
}