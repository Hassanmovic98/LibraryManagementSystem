package org.example.Service.ServiceImplementation;

import lombok.RequiredArgsConstructor;
import org.example.DTO.Request.CreateUserRequest;
import org.example.DTO.Request.LoginRequest;
import org.example.DTO.Response.CreateUserResponse;
import org.example.DTO.Response.LoginResponse;
import org.example.Model.User;
import org.example.Repository.UserRepository;
import org.example.Service.ServiceInterface.AuthorizationInterface;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class AuthorizationImplementation implements AuthorizationInterface {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public CreateUserResponse register (CreateUserRequest request){
        if (userRepository.existsByUsername(request.getUsername())){
            throw new RuntimeException("Username already exists");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());

         User savedUser = userRepository.save(user);
         return createUserResponseFromSavedUser(savedUser);


    }
    private static  CreateUserResponse createUserResponseFromSavedUser(User savedUser) {
        CreateUserResponse response = new CreateUserResponse();
        response.setUsername(savedUser.getUsername());
        response.setEmail(savedUser.getEmail());
        return response;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + request.getUsername()));
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");

        }
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage("login successful");
        loginResponse.setUsername(user.getUsername());
        return loginResponse;

    }


}
