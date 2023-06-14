package com.alexanderneumann.booktracker.service;

import com.alexanderneumann.booktracker.dto.BookDto;
import com.alexanderneumann.booktracker.models.Book;

import java.util.List;

public interface BookService {
    List<BookDto> findAllBooks();
    BookDto findBookById(long bookId);
    Book saveBook(BookDto bookDto);
    Book updateBook(long bookId, BookDto bookDto);
    void deleteBook(long bookId);
}
