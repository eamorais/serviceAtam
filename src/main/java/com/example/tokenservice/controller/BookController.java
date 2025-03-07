package com.example.tokenservice.controller;

import com.example.tokenservice.model.Book;
import com.example.tokenservice.model.BookDate;
import com.example.tokenservice.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/filter-books/{filter}")
    public Optional<BookDate> filterBooks(@PathVariable String filter) throws IOException {
        List<Book> books = bookService.readBooksFromJson();
        return bookService.filter(filter, books);
    }
    
    @GetMapping("/all")
    public List<Book> getAllBooks() throws IOException {
        return bookService.readBooksFromJson();
    }
}
