package com.library.library_app.service;

import com.library.library_app.model.Author;
import com.library.library_app.model.Book;
import com.library.library_app.repository.AuthorRepository;
import com.library.library_app.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookManagementService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository; // AuthorRepository dahil edildi

    // Constructor her iki repository'i de alacak şekilde güncellendi
    public BookManagementService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    // Yazar kontrolü yapan yeni addBook metodu
    public Book addBook(Book book) {
        if (book.getAuthor() != null && book.getAuthor().getName() != null) {
            String authorName = book.getAuthor().getName();

            // Yazar veritabanında var mı kontrolü
            Author existingAuthor = authorRepository.findByName(authorName).orElse(null);

            if (existingAuthor != null) {
                // Varsa mevcut yazarı çekip yeni kitaba bağla
                book.setAuthor(existingAuthor);
            } else {
                // Yoksa önce yeni yazarı oluştur, veritabanına kaydet ve sonra kitaba bağla
                Author newAuthor = new Author(authorName);
                newAuthor = authorRepository.save(newAuthor);
                book.setAuthor(newAuthor);
            }
        }
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Optional<Book> book1 = bookRepository.findById(id);
        if (book1.isEmpty()){
            return null;
        }
        Book originalBook = book1.get();
        originalBook.setTitle(book.getTitle());
        originalBook.setAuthor(book.getAuthor());
        return bookRepository.save(originalBook);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}