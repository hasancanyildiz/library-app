package com.library.library_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private final BookService bookService;
    private final LibInfo libInfo;

    public AppRunner(BookService bookService,LibInfo libInfo) {
        this.bookService = bookService;
        this.libInfo=libInfo;
    }

    @Override
    public void run(String... args) {
        System.out.println("Book Info: " + bookService.getBookInfo());
        System.out.println("Library Info : " +libInfo.getSummary() );
    }
}