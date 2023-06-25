package com.alexanderneumann.booktracker.service.impl;

import com.alexanderneumann.booktracker.dto.BookDto;
import com.alexanderneumann.booktracker.models.Book;
import com.alexanderneumann.booktracker.repository.BookRepository;
import com.alexanderneumann.booktracker.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDto> findAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map((book) -> mapToBookDto(book)).collect(Collectors.toList());
    }

    @Override
    public BookDto findBookById(long bookId) {
        Book book = bookRepository.findById(bookId).get();
        return mapToBookDto(book);
    }

    @Override
    public void saveBook(BookDto bookDto) {
        Book book = mapToBook(bookDto);
        bookRepository.save(book);
    }

    @Override
    public void updateBook(BookDto bookDto) {
        Book book = mapToBook(bookDto);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(long bookId) {
        Book existingBook = bookRepository.findById(bookId).orElse(null);
        if (existingBook == null) {
            throw new IllegalArgumentException("Book not found");
        }
        bookRepository.deleteById(bookId);
    }

    public BookDto mapToBookDto(Book book) {
        BookDto bookDto = BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .publishYear(book.getPublishYear())
                .imageUrl(book.getImageUrl())
                .build();
        return bookDto;
    }

    public Book mapToBook(BookDto bookDto) {
        Book book = Book.builder()
                .id(bookDto.getId())
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .isbn(bookDto.getIsbn())
                .publishYear(bookDto.getPublishYear())
                .imageUrl(bookDto.getImageUrl())
                .build();
        return book;
    }
}
