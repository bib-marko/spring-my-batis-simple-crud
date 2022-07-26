package com.library.book.repository;

import com.library.book.model.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Mapper
public interface BookRepository {

    @Select("SELECT * FROM book")
    List<Book> findAll();

    @Select("SELECT * FROM book WHERE id = #{id}")
    ResponseEntity<Book> findById(Long id);

    @Select("SELECT * FROM book WHERE isbn = #{isbn}")
    Book findIsbn(String isbn);

    @Delete("DELETE FROM book WHERE id = #{id}")
    int deleteById(Long id);

    @Insert("INSERT INTO book(isbn, title, author, book_desc, genre) VALUES (#{isbn}, #{title}, #{author}, #{description}, #{genre})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Book Book);

    @Update("UPDATE book SET isbn=#{isbn}, title=#{title}, author=#{author}, book_desc=#{description}, genre=#{genre} where id=#{id}")
    int update(Book book);


}
