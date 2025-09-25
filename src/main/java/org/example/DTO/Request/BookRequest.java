package org.example.DTO.Request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Data
public class BookRequest {

    @NotBlank(message = "your tittle can't be empty")
    private String title;

    private String genre;
    @NotNull(message = "Total copies is required")
    @Min(value = 1, message = "at least one")
    @Positive(message = "sorry only positive numbers")
    private int totalCopies;
    @Positive(message = "sorry,you can only insert a positive number")
    private int availableCopies;

}
