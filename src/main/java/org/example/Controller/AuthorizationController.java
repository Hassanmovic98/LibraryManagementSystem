package org.example.Controller;

import org.example.DTO.Request.CreateUserRequest;
import org.example.DTO.Request.LoginRequest;
import org.example.Service.ServiceImplementation.AuthorizationImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/LibraryManagementSystem")
public class AuthorizationController {

    @Autowired
    private AuthorizationImplementation authorizationImplementation;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest request){
        return ResponseEntity.ok(authorizationImplementation.register(request));
    }

    @PostMapping ("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authorizationImplementation.login(request));
    }




}
