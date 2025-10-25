package org.example.Controller;

import lombok.RequiredArgsConstructor;
import org.example.DTO.Request.CreateUserRequest;
import org.example.DTO.Request.LoginRequest;
import org.example.DTO.Response.CreateUserResponse;
import org.example.DTO.Response.LoginResponse;
import org.example.Service.ServiceInterface.AuthorizationInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/LibraryManagementSystem")
@RequiredArgsConstructor
public class AuthorizationController {


    private final AuthorizationInterface authroizationService;


    @PostMapping("/register")
    public ResponseEntity<CreateUserResponse> registerUser(@RequestBody CreateUserRequest request) {
        CreateUserResponse response = authroizationService.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest request) {
        LoginResponse response = authroizationService.login(request);
        return ResponseEntity.ok(response);
    }
}
