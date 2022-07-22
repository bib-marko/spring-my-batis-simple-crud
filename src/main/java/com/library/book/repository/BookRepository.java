package com.library.book.repository;

import com.library.book.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookRepository {

    @Select("SELECT * FROM book")
    List<Book> findAll();

    @Select("SELECT * FROM book WHERE id = #{id}")
    Book findById(long id);

    @Select("SELECT * FROM book WHERE isbn = #{isbn}")
    Book findIsbn(String isbn);

    @Insert("INSERT INTO book(isbn, title, author, book_desc, genre) VALUES (#{isbn}, #{title}, #{author}, #{description}, #{genre})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    Long insert(Book Book);

    @Delete("DELETE FROM book WHERE id = #{id}")
    void deleteById(long id);

    @Update("UPDATE book SET isbn=#{isbn}, title=#{title}, author=#{author}, book_desc=#{description}, genre=#{genre} where id=#{id}")
    int update(Book book);

}
