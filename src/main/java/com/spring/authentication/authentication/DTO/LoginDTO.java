package com.spring.authentication.authentication.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

        @Email(message = "Please enter valid email address!!!")
        private String email;

        @NotBlank(message = "Please enter password")
        @Size(min = 8)
        private String password;

}
