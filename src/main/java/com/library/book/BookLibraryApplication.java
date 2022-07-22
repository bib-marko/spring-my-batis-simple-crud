package com.library.book;

import ch.vorburger.exec.ManagedProcessException;
import com.library.book.database.Connection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookLibraryApplication {

    public static void main(String[] args) throws ManagedProcessException {
        Connection.buildDBConfiguration();
        SpringApplication.run(BookLibraryApplication.class, args);
    }

}
