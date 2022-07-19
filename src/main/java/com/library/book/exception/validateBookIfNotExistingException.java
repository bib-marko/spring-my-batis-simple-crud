package com.library.book.exception;

public class validateBookIfNotExistingException extends RuntimeException{
    public validateBookIfNotExistingException(Long id) {
        super("Book id: " + id + " is Not Existing");
    }
}
