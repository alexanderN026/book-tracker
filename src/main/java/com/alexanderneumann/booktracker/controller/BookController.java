package com.alexanderneumann.booktracker.controller;

import com.alexanderneumann.booktracker.dto.BookDto;
import com.alexanderneumann.booktracker.models.Book;
import com.alexanderneumann.booktracker.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //    Read
    @GetMapping("/books")
    public String books(Model model) {
        List<BookDto> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "books-list";
    }

    //    Create
    @GetMapping("/books/new")
    public String createBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "books-create";
    }

    @PostMapping("/books/new")
    public String saveBook(@Valid @ModelAttribute("book") BookDto bookDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("book", bookDto);
            return "books-create";
        }
        bookService.saveBook(bookDto);
        return "redirect:/books";
    }

    //    Update
    @GetMapping("/edit-book/{bookId}")
    public String editBookForm(@PathVariable("bookId") Long bookId, Model model) {
        BookDto bookDto = bookService.findBookById(bookId);
        model.addAttribute("bookDto", bookDto);
        return "books-edit";
    }

    @PostMapping("/edit-book/{bookId}")
    public String updateBook(@PathVariable("bookId") Long bookId,
                             @Valid @ModelAttribute("bookDto") BookDto bookDto,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books-edit";
        }
        bookDto.setId(bookId);
        bookService.updateBook(bookDto);
        return "redirect:/books";
    }

    //    Delete
    @GetMapping("/delete-book/{bookId}")
    public String deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/books";
    }
}

