package com.example.projet_integration.controller;

import com.example.projet_integration.dto.RegisterRequest;
import com.example.projet_integration.model.User;
import com.example.projet_integration.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;


    @GetMapping("/")
    public String home(){
        return "<h1>home</h1>";
    }
    @GetMapping("/user")
    public String user(){
        return "<h1>user</h1>";
    }
    @GetMapping("/admin")
    public String admin(){
        return "<h1>admin</h1>";
    }


    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
        System.out.println("testing2"+ registerRequest.getEmail() + registerRequest.getPassword() + registerRequest.getUsername());
        User user = new User();

        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword()); //c'est bon encoded
        // user.setCreated(Instant.now());

        user.setEnabled(true); //il user béch ykoun disabled before the email verification

        //userRepository.save(user);
        user.setRoles("user");

        authService.signup(user);

        return new ResponseEntity<>("User Registration Successful",
                OK);
    }
}
