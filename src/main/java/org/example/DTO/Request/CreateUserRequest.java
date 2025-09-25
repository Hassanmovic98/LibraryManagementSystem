package org.example.DTO.Request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
    @Data
    public class CreateUserRequest {
        @NotBlank(message = "Username can't be  empty")
        private String username;
        @NotBlank(message = "Email can't be empty")

        private String email;
        @NotBlank(message = "Password can't be empty")
        private String password;

    }

