package com.library.library_app;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book(1L, "Suç ve Ceza", "Dostoyevski"));
        books.add(new Book(2L, "1984", "George Orwell"));
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        for (Book book: books){
            if (book.getId().equals(id)){
                return book;
            }

        }
        return null;
    }


    @PostMapping

    public Book addBook(  @RequestBody Book book){
        books.add(book);
        return book;


    }


    @PutMapping("/{id}")
    public Book updateBook( @RequestBody Book book,@PathVariable Long id){
        for (Book bookOriginal : books){
            if (bookOriginal.getId().equals(id)){
                bookOriginal.setAuthor(book.getAuthor());
                bookOriginal.setTitle(book.getTitle());
            return bookOriginal;

            }
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        books.removeIf(book -> book.getId().equals(id));
        

    }

}