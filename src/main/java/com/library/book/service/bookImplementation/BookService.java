package com.library.book.service.bookImplementation;

import com.library.book.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
        List<Book> findAll();
        ResponseEntity<Book> insert(Book book);
        ResponseEntity<String> deleteById(Long id);
        ResponseEntity<String> update(Long id, Book bookDetails);
}
