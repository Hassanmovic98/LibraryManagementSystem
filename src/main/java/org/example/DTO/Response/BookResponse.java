package org.example.DTO.Response;

import lombok.Data;

@Data

public class BookResponse {
    private String id;
    private String title;
    private String genre;
    private int totalCopies;
    private int availableCopies;

}
