package com.example.projet_integration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfilRequest {

    private Long id;
    private String username ;
    private String fullName;
    private String job;
    private String about_me;
    private String mobile;
    private String email;
    private String location;
    private String experience;
    private String skills;
}
