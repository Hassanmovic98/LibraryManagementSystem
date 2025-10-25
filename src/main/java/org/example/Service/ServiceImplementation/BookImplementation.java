package org.example.Service.ServiceImplementation;

import lombok.RequiredArgsConstructor;
import org.example.Model.Book;
import org.example.Repository.BookRepository;
import org.example.Service.ServiceInterface.BookInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookImplementation  implements BookInterface {

    private final BookRepository bookRepository;


    @Override
    public Book addBook(Book book) {

        return bookRepository.save(book);
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

