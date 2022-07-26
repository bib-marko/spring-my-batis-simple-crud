package com.library.book.controller;

import com.library.book.model.Book;
import com.library.book.service.bookImplementation.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/list")
    List<Book> getAllBooks() { return bookService.findAll(); }

    @PostMapping(value = "/new")
    ResponseEntity<Book> newBook(@RequestBody Book book) {
        return bookService.insert(book);
    }

    @PostMapping(value = "/delete/{id}")
    ResponseEntity<String> deleteBook(@PathVariable Long id) {
        return bookService.deleteById(id);
    }

    @PostMapping("/update/{id}")
    ResponseEntity<String> updateBook(@PathVariable(value = "id") Long bookId, @RequestBody Book bookDetails) {
        bookDetails.setId(bookId);
        return bookService.update(bookId, bookDetails);
    }

    @RequestMapping(value = "/")
    public static String welcome(){
        return "index";
    }

}
