package org.example.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoginRequest {
    @NotBlank(message = "Username can't be empty")
    private  String username;
    @NotBlank(message = "Password can't be  empty")
    private  String password;


}
