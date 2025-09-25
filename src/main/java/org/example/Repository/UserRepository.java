package org.example.Repository;

import org.example.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository <User,String> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);


    Optional<User> findByEmail(String email);
}


