package com.library.library_app.controller;

import com.library.library_app.model.Book;
import com.library.library_app.service.BookManagementService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookManagementService bookManagementService;

    public BookController(BookManagementService bookManagementService) {
        this.bookManagementService = bookManagementService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookManagementService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookManagementService.getBookById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookManagementService.addBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookManagementService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookManagementService.deleteBook(id);
    }
}