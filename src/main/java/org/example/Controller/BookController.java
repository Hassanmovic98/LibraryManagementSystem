package org.example.Controller;

import lombok.RequiredArgsConstructor;
import org.example.Model.Book;
import org.example.Service.ServiceInterface.BookInterface;
import org.example.Service.ServiceInterface.BookShelveInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
@RequiredArgsConstructor

public class BookController {

    private final BookInterface bookService;
    private  final BookShelveInterface bookShelveInterface ;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }
    @GetMapping
    public ResponseEntity<Book>getBookById(@PathVariable String id) {
        return bookService.getBookById(id)
                .map(book -> ResponseEntity.ok(book))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

}







