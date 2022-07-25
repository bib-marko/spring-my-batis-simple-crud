package com.library.book.service.bookImplementation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.library.book.exception.BookIsbnExistException;
import com.library.book.exception.BookIfNotExistException;
import com.library.book.exception.BookSizeException;
import com.library.book.exception.throwFieldsNullExeption;
import com.library.book.model.Book;
import com.library.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
    public void insert(Book book) {
        if(bookRepository.findIsbn(book.getIsbn()) != null){ throwBookIsbnErrorException(book.getIsbn()); }
        Long id =  bookRepository.insert(book);
        book.setId(id);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Book> bookData = Optional.ofNullable(bookRepository.findById(id));
        if (bookData.isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throwBookIsNotExistingException(id);
        }
    }

    @Override
    public void update(Long id, Book bookDetails) {
        Optional<Book> bookData = Optional.ofNullable(bookRepository.findById(bookDetails.getId()));
        if(!(bookData.isPresent())){
            throwBookIsNotExistingException(bookDetails.getId());
        }
        bookDetails.setId(id);
        bookRepository.update(bookDetails);
    }

    private void throwBookIsNotExistingException(long id) {throw new BookIfNotExistException(id);}
    private List<Book> throwBookSizeException() { throw new BookSizeException(); }
    private void throwBookIsbnErrorException(String isbn) { throw new BookIsbnExistException(isbn); }

}
