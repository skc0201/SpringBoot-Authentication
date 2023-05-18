package com.spring.authentication.authentication.service;

import com.spring.authentication.authentication.DTO.LoginDTO;
import com.spring.authentication.authentication.DTO.UserDTO;
import com.spring.authentication.authentication.config.CustomException;
import com.spring.authentication.authentication.entity.User;
import com.spring.authentication.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User saveUser(UserDTO user) {
        System.out.println(user + "user--- in saved user");
        User newUser = new User(

                user.getId(),
                user.getName(),
                user.getEmail(),
                this.passwordEncoder.encode(user.getPassword())
        );

        userRepository.save(newUser);

        return newUser;
    }

    @Override
    public ResponseEntity<String> login(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if (user != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> loggedUser = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (loggedUser.isPresent()) {
                    return  ResponseEntity.ok("Login Successfully!!!");
                } else {
                    return  ResponseEntity.ok("Login Failed,  please check your email or password");
                }
            } else {
                return  ResponseEntity.ok("Password incorrect!!!!!");
            }
        }else {
            return  ResponseEntity.ok("Email not exists!!!");
        }
    }
}
