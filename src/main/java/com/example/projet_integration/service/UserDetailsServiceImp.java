package com.example.projet_integration.service;

import com.example.projet_integration.model.User;
import com.example.projet_integration.repository.UserRepository;
import com.example.projet_integration.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    UserRepository userRepository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     //Optional<User> user =userRepository.findByUsername(username);
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
     user.orElseThrow(()-> new UsernameNotFoundException("Not found:" + username));
     return  user.map(MyUserDetails::new).get();
    }
}
