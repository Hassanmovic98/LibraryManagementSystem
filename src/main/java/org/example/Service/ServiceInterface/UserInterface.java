package org.example.Service.ServiceInterface;

import org.example.DTO.Request.GetUserRequest;
import org.example.DTO.Request.LoginRequest;
import org.example.DTO.Request.CreateUserRequest;
import org.example.DTO.Response.CreateUserResponse;
import org.example.DTO.Response.GetUserResponse;
import org.example.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserInterface {

    CreateUserResponse createUser(CreateUserRequest createUserRequest);


    GetUserResponse getUserById(GetUserRequest getUsersRequest);


    List<GetUserResponse> getAllUsers();

    GetUserResponse getUserByUsername(String username);

    GetUserResponse getUserByEmail(String Email);
}

