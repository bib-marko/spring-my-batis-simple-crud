package com.library.book.controller;

import com.library.book.model.Book;
import com.library.book.service.bookImplementation.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/list")
    List<Book> getAllBooks() { return bookService.findAll(); }

    @PostMapping(value = "/new")
    void newBook(@RequestBody Book book) {
        bookService.insert(book);
    }

//    @PostMapping(value = "/delete/{id}")
//    void deleteBook(@PathVariable Long id) {
//        bookService.deleteById(id);
//    }

//    @PostMapping("/update/{id}")
//    int updateBook(@PathVariable(value = "id") Long bookId, @RequestBody Book bookDetails) {
//        bookDetails.setId(bookId);
//        return bookService.update(bookId, bookDetails);
//    }

    @PostMapping(value = "/delete/{id}")
    void deleteBook(@PathVariable String id) {
        String[] listOfId = id.split(",");
        for(String list : listOfId){
            bookService.deleteById(Long.valueOf(list));
        }

    }

    @PostMapping("/update/{id}")
    void updateBook(@PathVariable(value = "id") String bookId, @RequestBody Book bookDetails) {
        String[] listOfId = bookId.split(",");
        for(String list : listOfId){
            bookDetails.setId(Long.parseLong(list));
            bookService.update(Long.valueOf(list), bookDetails);
        }
    }

    @RequestMapping(value = "/")
    public static String welcome(){
        return "index";
    }

}
