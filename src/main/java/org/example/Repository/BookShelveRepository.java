package org.example.Repository;

import org.example.Model.BookShelve;
import org.example.Model.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

    public interface BookShelveRepository extends MongoRepository<BookShelve, String> {

        Optional<BookShelve> findByBookId(String userId);

        List<BookShelve> findByUserId(String userId);

        List<BookShelve> findByUserIdAndStatus(String userId, Status status);
    }
