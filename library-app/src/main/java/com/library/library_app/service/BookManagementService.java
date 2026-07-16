package com.library.library_app.service;

import com.library.library_app.model.Book;
import com.library.library_app.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookManagementService {

    private final BookRepository bookRepository;

    public BookManagementService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public Book getBookById(Long id) {
        return bookRepository.getBookById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.addBook(book);
    }

    public Book updateBook(Long id, Book book) {
        return bookRepository.updateBook(book, id);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteBook(id);
    }
}