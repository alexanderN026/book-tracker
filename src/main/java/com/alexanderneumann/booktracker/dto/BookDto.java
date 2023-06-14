package com.alexanderneumann.booktracker.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private long id;
    private String title;
    private String author;
    private String isbn;
    private String publishYear;
    private String imageUrl;
}
