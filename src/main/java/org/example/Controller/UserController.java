package org.example.Controller;

import lombok.AllArgsConstructor;
import org.example.DTO.Request.CreateUserRequest;
import org.example.DTO.Request.GetUserRequest;
import org.example.DTO.Response.CreateUserResponse;
import org.example.DTO.Response.GetUserResponse;
import org.example.Service.ServiceImplementation.UserImplementation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/LibraryManagementSystem")
@AllArgsConstructor
public class UserController {
    private UserImplementation userImplementation;

    @PostMapping ("/createUser")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest request){
        CreateUserResponse createUserResponse = userImplementation.createUser(request);
        return ResponseEntity.ok(createUserResponse);
    }

    @GetMapping("/getUserID")
    public ResponseEntity<?> getUserById(@RequestParam String userId){
        GetUserRequest GetUserRequest = new GetUserRequest();
        GetUserRequest.setUserId(userId);
        GetUserResponse getUserResponse = userImplementation.getUserById(GetUserRequest);
        return ResponseEntity.ok(getUserResponse);
    }
   @GetMapping("getUsersByUsername")
    public ResponseEntity<?> getUserByUsername(@RequestParam CreateUserRequest request){
       GetUserResponse getUserResponse = userImplementation.getUserByUsername(request.getUsername());
       return ResponseEntity.ok(getUserResponse);
    }


}
