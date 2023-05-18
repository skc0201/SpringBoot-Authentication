package com.spring.authentication.authentication.service;

import com.spring.authentication.authentication.DTO.LoginDTO;
import com.spring.authentication.authentication.DTO.UserDTO;
import com.spring.authentication.authentication.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User saveUser(UserDTO userDTO);
    ResponseEntity<String> login(LoginDTO loginDTO);
}
