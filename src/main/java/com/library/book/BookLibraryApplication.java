package com.library.book;

import ch.vorburger.exec.ManagedProcessException;
import com.library.book.controller.BookController;
import com.library.book.database.Connection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class BookLibraryApplication {

    public static void main(String[] args) throws ManagedProcessException {
        Connection.buildDBConfiguration();
        new File(BookController.welcome()).mkdir();
        SpringApplication.run(BookLibraryApplication.class, args);
    }

}
