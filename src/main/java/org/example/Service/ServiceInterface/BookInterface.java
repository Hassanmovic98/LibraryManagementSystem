package org.example.Service.ServiceInterface;

import org.example.Model.Book;

import java.util.List;
import java.util.Optional;

public interface BookInterface {

    List<Book> getAllBooks();
    Optional<Book> getBookById(String id);

}
