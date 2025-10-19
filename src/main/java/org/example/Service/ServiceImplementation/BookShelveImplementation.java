package org.example.Service.ServiceImplementation;

import org.example.Model.Book;
import org.example.Model.BookShelve;
import org.example.Model.Status;

import org.example.Repository.BookRepository;
import org.example.Repository.BookShelveRepository;
import org.example.Repository.UserRepository;
import org.example.Service.ServiceInterface.BookShelveInterface;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;



@Service
public class BookShelveImplementation implements BookShelveInterface {

    private final BookShelveRepository bookShelveRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookShelveImplementation(BookShelveRepository bookShelveRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.bookShelveRepository = bookShelveRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public BookShelve bookShelve(String userId, String bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getAvailableCopies() <= 0) {
            throw new RuntimeException("Book not available");
        }

        userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        BookShelve shelf = new BookShelve();
        shelf.setUserId(userId);
        shelf.setBookId(bookId);
        shelf.setStatus(Status.BORROWED);
        shelf.setBorrowedDate(LocalDate.now());

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);

        return bookShelveRepository.save(shelf);
    }

    @Override
    public BookShelve returnBook(String userId, String bookId) {
        List<BookShelve> userShelves = bookShelveRepository.findByUserId(userId);

        BookShelve shelf = userShelves.stream()
                .filter(s -> s.getBookId().equals(bookId) && s.getStatus() == Status.BORROWED)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));

        shelf.setStatus(Status.RETURNED);
        shelf.setReturnDate(LocalDate.now());
        bookShelveRepository.save(shelf);

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);

        return shelf;
    }


    @Override
    public List<BookShelve> viewBookShelves(String userId) {

        return bookShelveRepository.findByUserId(userId);
    }

    @Override
    public List<BookShelve> getShelvesByStatus(String userId, Status status) {
        return bookShelveRepository.findByUserIdAndStatus(userId, status);
    }
}
