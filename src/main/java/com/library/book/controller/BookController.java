package com.library.book.controller;

import com.library.book.exception.validateBookIfExistingException;
import com.library.book.exception.validateBookIfNotExistingException;
import com.library.book.exception.validateBookSize;
import com.library.book.model.Book;
import com.library.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/list")
    List<Book> getAllBooks(){ return bookRepository.findAll(); }

    @PostMapping(value = "/new")
    int newBook(@RequestBody Book book) {
        try{
            return bookRepository.insert(book);
        }catch (RuntimeException ex){
            throw new validateBookIfExistingException(book.getId());
        }
    }

    @PostMapping(value = "/delete/{id}")
    void deleteBook(@PathVariable Long id) {
        Optional<Book> bookData = Optional.ofNullable(bookRepository.findById(id));
        if(bookData.isPresent()){
            bookRepository.deleteById(id);
        }else{
            throw new validateBookIfNotExistingException(id);
        }
    }

    @PostMapping("/update/{id}")
    int updateBook(@PathVariable(value = "id") Long bookId, @RequestBody Book bookDetails) {
        try{
            Book book = new Book(bookId, bookDetails.getIsbn(), bookDetails.getTitle(), bookDetails.getAuthor(), bookDetails.getDescription(), bookDetails.getGenre());
            return bookRepository.update(book);
        }catch (RuntimeException ex){
            throw new validateBookIfNotExistingException(bookId);
        }
    }


}
