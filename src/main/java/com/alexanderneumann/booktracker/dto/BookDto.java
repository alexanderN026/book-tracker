package com.alexanderneumann.booktracker.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private long id;

    @NotEmpty(message = "Book title should not be empty")
    private String title;

    @NotEmpty(message = "Book author should not be empty")
    private String author;

    @NotEmpty(message = "Book ISBN should not be empty")
    private String isbn;

    @NotEmpty(message = "Book publish year should not be empty")
    private String publishYear;

    @NotEmpty(message = "Book image link should not be empty")
    private String imageUrl;
}
