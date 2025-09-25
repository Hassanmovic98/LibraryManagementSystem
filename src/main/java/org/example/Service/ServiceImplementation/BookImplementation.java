package org.example.Service.ServiceImplementation;

import org.example.Model.Book;
import org.example.Repository.BookRepository;
import org.example.Service.ServiceInterface.BookInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookImplementation  implements BookInterface {

    private final BookRepository bookRepository;

    @Autowired
    public BookImplementation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }
}

