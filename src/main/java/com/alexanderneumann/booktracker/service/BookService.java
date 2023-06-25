package com.alexanderneumann.booktracker.service;

import com.alexanderneumann.booktracker.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> findAllBooks();

    BookDto findBookById(long bookId);

    void saveBook(BookDto bookDto);

    void updateBook(BookDto bookDto);

    void deleteBook(long bookId);
}
