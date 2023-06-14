package com.alexanderneumann.booktracker.controller;

import com.alexanderneumann.booktracker.dto.BookDto;
import com.alexanderneumann.booktracker.models.Book;
import com.alexanderneumann.booktracker.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseBody
    @GetMapping("/books")
    public List<BookDto> findAllBooks() {
        return bookService.findAllBooks();
    }

    @ResponseBody
    @GetMapping("/books/{id}")
    public BookDto findBookById(@PathVariable int id) {
        return bookService.findBookById(id);
    }

    @ResponseBody
    @PostMapping("/books")
    public Book saveBook(@RequestBody BookDto bookDto) {
        return bookService.saveBook(bookDto);
    }

    @ResponseBody
    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody BookDto bookDto) {
        return bookService.updateBook(id, bookDto);
    }

    @ResponseBody
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }

}

