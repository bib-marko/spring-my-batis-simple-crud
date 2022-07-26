package com.library.book.service.bookImplementation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.library.book.exception.BookIsbnExistException;
import com.library.book.exception.BookIfNotExistException;
import com.library.book.exception.BookSizeException;
import com.library.book.exception.FieldsNullException;
import com.library.book.model.Book;
import com.library.book.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        List<Book> listOfBook = bookRepository.findAll();
        return listOfBook == null || listOfBook.isEmpty() ? throwBookSizeException() : listOfBook;
    }

    @Override
    public ResponseEntity<Book> insert(Book book) {
        if (bookRepository.findIsbn(book.getIsbn()) != null) { throwBookIsbnErrorException(book.getIsbn());}
        try{
            book.setId(book.getId());
            bookRepository.insert(book);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }catch (Exception e){
            return throwBookFieldsNullException(e.getCause().getMessage().substring(10));
        }
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        return (bookRepository.deleteById(id) < 1) ? throwBookIsNotExistingException(String.valueOf(id)) : new ResponseEntity<>("Book ID Number : " +  id + " is successfully deleted!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> update(Long id, Book bookDetails) {
           return bookRepository.update(bookDetails) < 1 ? throwBookIsNotExistingException(String.valueOf(id)) : new ResponseEntity<>("Book ID Number : " +  id + " is successfully updated!", HttpStatus.OK);
    }

    private ResponseEntity<Book> throwBookFieldsNullException(String message) { throw new FieldsNullException(message); }
    private ResponseEntity<String> throwBookIsNotExistingException(String id) { throw new BookIfNotExistException(id);}
    private List<Book> throwBookSizeException() { throw new BookSizeException(); }
    private void throwBookIsbnErrorException(String isbn) { throw new BookIsbnExistException(isbn); }


}
