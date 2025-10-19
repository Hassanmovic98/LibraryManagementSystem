package org.example.Controller;

import lombok.RequiredArgsConstructor;
import org.example.DTO.Request.BookShelveRequest;
import org.example.Model.Book;
import org.example.Model.BookShelve;
import org.example.Model.Status;
import org.example.Repository.BookShelveRepository;
import org.example.Service.ServiceInterface.BookInterface;
import org.example.Service.ServiceInterface.BookShelveInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor

public class BookController {


private final BookShelveInterface bookShelveService;



    @PostMapping("/bookBorrow")
    public ResponseEntity<BookShelve> borrowBook (@RequestBody String userId, @RequestParam String bookId){
        BookShelve bookShelve = bookShelveService.bookShelve(userId,bookId);
        return ResponseEntity.ok(bookShelve);

}
@PostMapping("/returnBook")
    public ResponseEntity<BookShelve> returnBook(@RequestBody String userId, @RequestParam String bookId){
    BookShelve bookShelve = bookShelveService.returnBook(userId,bookId);
    return ResponseEntity.ok(bookShelve);
}
@GetMapping("/user/{userId}/bookShelves")
    public ResponseEntity<List<BookShelve>> getAllUserShelve(@PathVariable String userId){
        return ResponseEntity.ok(bookShelveService.viewBookShelves(userId));

}
@GetMapping("/user/{userId}/borrowed")
    public ResponseEntity<List<BookShelve>> getBorrowedBooks(@PathVariable String userId) {
        return ResponseEntity.ok(bookShelveService.getShelvesByStatus(userId, Status.BORROWED));
    }


}







