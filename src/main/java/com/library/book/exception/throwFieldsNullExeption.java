package com.library.book.exception;

public class throwFieldsNullExeption extends RuntimeException{
    public throwFieldsNullExeption() {
        super("Something missing with your fields!");
    }
}
