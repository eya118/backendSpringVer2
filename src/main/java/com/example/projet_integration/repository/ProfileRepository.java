package com.example.projet_integration.repository;


import com.example.projet_integration.model.profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository  extends JpaRepository<profile, Long> {
    //profile getprofileBy_username(Long username);
    profile findByUsername(String username);
}
