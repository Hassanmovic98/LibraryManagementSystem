package org.example.Service.ServiceInterface;

import org.example.DTO.Request.CreateUserRequest;
import org.example.DTO.Request.LoginRequest;
import org.example.DTO.Response.CreateUserResponse;
import org.example.DTO.Response.LoginResponse;

public interface AuthorizationInterface {
    CreateUserResponse register(CreateUserRequest request);
    LoginResponse login (LoginRequest request);

}
