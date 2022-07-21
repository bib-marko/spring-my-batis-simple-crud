package com.library.book.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book{
    private long id;
    private String isbn, title, author, description,genre;

    public Book(Long id, String isbn, String title, String author, String description, String genre) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
        this.genre = genre;
    }
}
