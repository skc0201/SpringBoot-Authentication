package com.spring.authentication.authentication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @NotBlank(message = "Name is required")
    private String name;
    @Column(name = "email")
    @NotBlank(message = "Email is mandatory")
//    @Email(regexp = "^[a-z0-9](\\.?[a-z0-9]){5,}@zemosolabs\\.com$" , message = "Enter Valid email address!!")
    private String email;

    @Column(name = "password")
    @Size(min = 8 , message = "Password should have minimum 8 characters!!!")
//    @Pattern(regexp = "/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\\w\\s]).{8,}$/")
    private String password;


}

