package com.library.book.exception;

public class validateBookSize extends RuntimeException {
    public validateBookSize() {
        super("There is no book yet!");
    }
}
