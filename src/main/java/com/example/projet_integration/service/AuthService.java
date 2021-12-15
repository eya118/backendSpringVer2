package com.example.projet_integration.service;

import com.example.projet_integration.dto.RegisterRequest;
import com.example.projet_integration.model.User;
import com.example.projet_integration.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class AuthService {

    @Autowired
    private final UserRepository userRepository;


    /*public List<User> findall() {

     return userRepository.findAll();


    }
*/

    public void  signup(User user) {
        userRepository.save(user);


    }
   public User fetchByUsernameAndPassword(String username ,String password){

      return userRepository.findByUsernameAndPassword(username,password);
    }
    public User fetchByUserName(String username){
        return  userRepository.findByUsername(username);
    }
}
