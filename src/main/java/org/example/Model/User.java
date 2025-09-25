package org.example.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Optional;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String userId;
    private String username;
    private String email;
    private String password;


    public boolean isPresent() {
        return true;
    }

    public Optional<User> filter(Object o) {
        return Optional.of(this);
    }
}
