package com.library.book.exception;

public class validateBookIfExistingException extends RuntimeException{
    public validateBookIfExistingException(long id) {
        super("Book id: " + id + " is Already Exist");
    }
}
