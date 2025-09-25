package org.example.Service.ServiceImplementation;


import lombok.AllArgsConstructor;
import org.example.DTO.Request.GetUserRequest;
import org.example.DTO.Request.CreateUserRequest;
import org.example.DTO.Response.CreateUserResponse;
import org.example.DTO.Response.GetUserResponse;
import org.example.Model.User;
import org.example.Repository.UserRepository;
import org.example.Service.ServiceInterface.UserInterface;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;



@Service
@AllArgsConstructor
public class UserImplementation implements UserInterface {

    private final UserRepository userRepository;



    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        if (userRepository.existsByUsername(createUserRequest.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        User user = new User();
        user.setUsername(createUserRequest.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(createUserRequest.getPassword()));
        user.setEmail(createUserRequest.getEmail());
        userRepository.save(user);
        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setUsername(user.getUsername());
        createUserResponse.setEmail(user.getEmail());
        return createUserResponse;
    }

    @Override
    public GetUserResponse getUserById(GetUserRequest getUsersRequest) {
        User user  = new User();
        userRepository.findById(getUsersRequest.getUserId()).orElseThrow(() -> new RuntimeException("User not found with id: " + getUsersRequest.getUserId()));
        GetUserResponse response  = new GetUserResponse();
        response.setUsername(user.getUsername());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        return response;


    }

    @Override
    public List<GetUserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            throw new RuntimeException("Users not found");
        }
        for (User user : users) {
            GetUserResponse response = new GetUserResponse();
            response.setUsername(user.getUsername());
            response.setEmail(user.getEmail());
            response.setUserId(user.getUserId());

        }
        return List.of(new GetUserResponse());

    }

    @Override
    public GetUserResponse getUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found with id: " + username);
        }
        User user = optionalUser.get();
        GetUserResponse response = new GetUserResponse();
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());

        return response;
    }

    @Override
    public GetUserResponse getUserByEmail(String Email){
        Optional<User> optionalUser = userRepository.findByEmail(Email);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found with id: " + Email);
        }
        User user = optionalUser.get();
        GetUserResponse response = new GetUserResponse();
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        return response;
    }

}













