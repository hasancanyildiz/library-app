package com.library.library_app.repository;

import com.library.library_app.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private final List<Book> books = new ArrayList<>();

    public BookRepository() {
        books.add(new Book(1L, "Suç ve Ceza", "Dostoyevski"));
        books.add(new Book(2L, "1984", "George Orwell"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public Book updateBook(Book book, Long id) {
        for (Book bookOriginal : books) {
            if (bookOriginal.getId().equals(id)) {
                bookOriginal.setAuthor(book.getAuthor());
                bookOriginal.setTitle(book.getTitle());
                return bookOriginal;
            }
        }
        return null;
    }

    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}