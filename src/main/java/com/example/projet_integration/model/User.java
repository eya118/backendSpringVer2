package com.example.projet_integration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

import static javax.persistence.GenerationType.IDENTITY;

//good , we still n eed the privilege
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Cette annotation indique que la clé primaire est générée de façon automatique
    private Long userId;
    //@NotBlank(message = "Username is required")
    private String username;
    //@NotBlank(message = "Password is required")
    private String password;
    //@Email
    //@NotEmpty(message = "Email is required")
    private String email;
    //private Instant created;
    private boolean enabled; //il user béch ykoun enabled after the email verification
    private String roles ;
}
