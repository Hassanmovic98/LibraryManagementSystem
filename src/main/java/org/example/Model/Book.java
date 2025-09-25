package org.example.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "books")

public class Book {
    @Id
    private String BookId;
    private String title;
    private String genre;
    private int totalCopies;
    private int availableCopies;

}
