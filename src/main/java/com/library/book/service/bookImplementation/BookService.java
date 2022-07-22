package com.library.book.service.bookImplementation;

import com.library.book.model.Book;
import java.util.List;

public interface BookService {
        List<Book> findAll();
        void insert(Book book);
        void deleteById(Long id);
        void update(Long bookId, Book bookDetails);
}
