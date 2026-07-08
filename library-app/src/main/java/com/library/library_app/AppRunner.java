package com.library.library_app;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private final BookService bookService;
    private final LibInfo libInfo;
    private final NotificationSender notificationSender;

    public AppRunner(@Qualifier("EBookService") BookService bookService, LibInfo libInfo, NotificationSender notificationSender) {
        this.bookService = bookService;
        this.libInfo = libInfo;
        this.notificationSender = notificationSender;
    }

    @Override
    public void run(String... args) {
        System.out.println("Book Info: " + bookService.getBookInfo());
        System.out.println("Library Info: " + libInfo.getSummary());
        notificationSender.send("New book added!");
    }
}