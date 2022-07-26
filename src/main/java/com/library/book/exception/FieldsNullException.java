package com.library.book.exception;

public class FieldsNullException extends RuntimeException{
    public FieldsNullException(String message) {
        super(message + ". Please Fill it out the field!");
    }
}
