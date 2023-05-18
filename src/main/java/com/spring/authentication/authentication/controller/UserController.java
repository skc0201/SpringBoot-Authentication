package com.spring.authentication.authentication.controller;

import com.spring.authentication.authentication.DTO.LoginDTO;
import com.spring.authentication.authentication.DTO.UserDTO;
import com.spring.authentication.authentication.entity.User;
import com.spring.authentication.authentication.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @PostMapping("/signup")
    public User add(@Valid @RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid  @RequestBody LoginDTO loginDTO){
        return userService.login(loginDTO);
    }
}
