package com.library.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@Data - for all
@Getter
@Setter
@AllArgsConstructor
public class Book{
    private long id;
    private String isbn, title, author, description,genre;
}
