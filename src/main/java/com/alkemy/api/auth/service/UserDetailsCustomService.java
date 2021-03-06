package com.alkemy.api.auth.service;

import com.alkemy.api.auth.dto.UserDTO;
import com.alkemy.api.auth.entity.UserEntity;
import com.alkemy.api.auth.repository.UserRepository;
import com.alkemy.api.exception.ParamNotFound;
import com.alkemy.api.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userRepository.findByUserName(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("Username or password not found");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }

    public boolean save(@Valid UserDTO userDTO) throws IOException {
        UserEntity userEntity = new UserEntity();
        UserEntity findUser = this.userRepository.findByUserName(userDTO.getUserName());
        if (findUser != null) {
            throw new ParamNotFound("Username already exist");
        }
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setPassword(encoder.encode(userDTO.getPassword()));
        userEntity = this.userRepository.save(userEntity);
        if(userEntity != null) {
            emailService.sendWelcomeEmailTo(userEntity.getUsername());
        }
        return userEntity != null;
    }


}
