package com.example.projet_integration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class profile {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id")
    private Long id;
    private String username;
    private String fullName;
    private String job;
    private String about_me;
    private String mobile;
    private String email;
    private String location;
    private String experience;
    private String skills;



}
