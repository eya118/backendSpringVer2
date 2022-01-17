package com.example.projet_integration.controller;

import com.example.projet_integration.dto.LoginRequest;
import com.example.projet_integration.dto.RegisterRequest;
import com.example.projet_integration.model.User;
import com.example.projet_integration.model.profile;
import com.example.projet_integration.repository.ProfileRepository;
import com.example.projet_integration.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private ProfileRepository profileRepository ;


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

    @CrossOrigin(origins =  "http://localhost:4200")
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) throws Exception {
        User userObj=null;
       if(registerRequest!=null &&registerRequest!=null ){
          userObj= authService.fetchByUserName(registerRequest.getUsername());
       }
       if (userObj!=null){
           throw new Exception("user already exists !");}


        User user = new User();

        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword()); //c'est bon encoded
        user.setCreated(Instant.now());

        user.setEnabled(true); //il user béch ykoun disabled before the email verification

        //userRepository.save(user);
        user.setRoles("user");
         profile profile = new profile();
         profile.setUsername(user.getUsername());
         profile.setEmail(user.getEmail());
         profileRepository.save(profile);
        authService.signup(user);

        return new ResponseEntity<>("\" spring: you are registered\"",OK);
    }

    @CrossOrigin(origins =  "http://localhost:4200")
    @GetMapping("/FindByName/{name}")
    public ResponseEntity<User> FindByName(@PathVariable("name") String name) throws Exception {
        User userObj=null;
        if(name!=null){
           userObj=authService.fetchByUserName(name);
           return new ResponseEntity<>(userObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(userObj, NOT_FOUND);
        
    }

    @PostMapping("/testing")
    public ResponseEntity<String> testing (@RequestBody LoginRequest registerRequest) {
        System.out.println("********username*****"+registerRequest.getUsername()+"**********password********"+registerRequest.getPassword());
        return new ResponseEntity<>("\" spring: you are registered\"",OK);
    }

    @PostMapping("/log")
    @CrossOrigin(origins =  "http://localhost:4200")
    public ResponseEntity<String> login(@RequestBody LoginRequest registerRequest) {
        User user = new User();
        User userObj=null;
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        System.out.println("********username*****"+user.getUsername()+"**********password********"+user.getPassword());
        if(user!=null){
           userObj=authService.fetchByUsernameAndPassword(user.getUsername(),user.getPassword());
        }
        if(userObj!=null){

            return new ResponseEntity<>("\" spring message: you are connected\"",OK);

        }
        else{
            return new ResponseEntity<>("you are not authenticated , try again",NOT_FOUND);
        }

    }
}
