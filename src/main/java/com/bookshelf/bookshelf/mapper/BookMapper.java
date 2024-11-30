package com.bookshelf.bookshelf.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bookshelf.bookshelf.data.BookDTO;
import com.bookshelf.bookshelf.entities.Book;

@Mapper
public interface BookMapper {

    List<BookDTO> mapBooks(List<Book> books);
    List<Book> mapBookDTOs(List<BookDTO> books);

    BookDTO mapBook(Book book);
    Book mapBookDTO(BookDTO book);
    
}
