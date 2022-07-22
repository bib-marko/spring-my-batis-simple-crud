package com.library.book.exception;

public class BookIsbnExistException extends RuntimeException{
    public BookIsbnExistException(String isbn) {
        super(String.format("Book with ISBN number: %s is Already Existing!", isbn));
    }
}
