package com.example.projet_integration.controller;

import com.example.projet_integration.model.User;
import com.example.projet_integration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.status;




@CrossOrigin(origins =  "http://localhost:4200")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

 //get a user by username
    @CrossOrigin(origins =  "http://localhost:4200")
    @GetMapping("{username}")
    public ResponseEntity<User> getPostsBycat(@PathVariable("username") String username) {
        System.out.println(userRepository.findByUsername(username));
        User user= userRepository.findByUsername(username);

        return status(HttpStatus.OK).body(user);
    }
}
