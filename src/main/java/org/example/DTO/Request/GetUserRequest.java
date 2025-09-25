package org.example.DTO.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GetUserRequest {
    private String userId;
    private String username;
    private String email;
}
