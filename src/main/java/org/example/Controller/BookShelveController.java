package org.example.Controller;

import lombok.RequiredArgsConstructor;
import org.example.Model.BookShelve;
import org.example.Service.ServiceInterface.BookShelveInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class BookShelveController {
    private final BookShelveInterface bookShelveService;

    @PostMapping("/borrowBook")
    public  ResponseEntity<BookShelve> borrowBook(@RequestParam String userid, @RequestParam String bookId){
        BookShelve returned = bookShelveService.bookShelve(userid, bookId);
        return ResponseEntity.ok(returned);

    }
    @PostMapping("/returnBooks")
    public ResponseEntity<BookShelve> returnBook(@RequestParam String userid, @RequestParam String bookId){
        BookShelve returned = bookShelveService.returnBook(userid, bookId);
        return ResponseEntity.ok(returned);
    }

    @PostMapping
    public ResponseEntity<List<BookShelve>> viewBookShelves(@RequestParam String userId){
        List <BookShelve> shelves = bookShelveService.viewBookShelves(userId);
        return ResponseEntity.ok(shelves);
    }









}
