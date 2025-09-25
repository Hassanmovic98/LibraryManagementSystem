package org.example.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class BookShelve {
    @Id
    private String id;
    @DBRef
    private User user;
    @DBRef
    private Book book;
    private Status status;
    private LocalDate borrowedDate;
    private LocalDate returnDate;

    public void setUserId(String userId) {
    }

    public void setBookId(String bookId) {
    }

    public Object getBookId() {
        return null;
    }
}
