package com.library.book.exception;

public class BookSizeException extends RuntimeException{
    public BookSizeException() {
        super("Book size is empty!");
    }
}
