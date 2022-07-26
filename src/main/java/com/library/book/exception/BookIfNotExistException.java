package com.library.book.exception;

public class BookIfNotExistException extends RuntimeException{
    public BookIfNotExistException(String id) {
        super(String.format("Book number: %s is not Existing!", id));
    }
}
