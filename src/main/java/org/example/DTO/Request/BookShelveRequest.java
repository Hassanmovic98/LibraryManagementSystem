package org.example.DTO.Request;

import lombok.Data;
import org.example.Model.Book;
import org.example.Model.Status;
import org.example.Model.User;

import java.time.LocalDateTime;
@Data
public class BookShelveRequest {
    private User user;
    private Book book;
    private LocalDateTime borrowedDate;
    private LocalDateTime returnDate;
    private Status status;
}
