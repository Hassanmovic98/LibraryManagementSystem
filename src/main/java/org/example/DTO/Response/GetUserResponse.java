package org.example.DTO.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserResponse {
    private String UserId;
    private String username;
    private String email;
}
