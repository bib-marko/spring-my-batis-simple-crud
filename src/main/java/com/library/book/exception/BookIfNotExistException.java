package com.library.book.exception;

public class BookIfNotExistException extends RuntimeException{
    public BookIfNotExistException(Long id) {
        super(String.format("Book number: %d is not Existing!", id));
    }

}
