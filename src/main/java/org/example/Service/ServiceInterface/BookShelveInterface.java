package org.example.Service.ServiceInterface;

import org.example.Model.BookShelve;

import java.util.List;

public interface BookShelveInterface {
    BookShelve bookShelve(String userId, String bookId);
    List<BookShelve> viewBookShelves(String userId);
    BookShelve returnBook (String userId, String bookId);


}
