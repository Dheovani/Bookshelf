package com.bookshelf.bookshelf.service;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshelf.bookshelf.data.BookDTO;
import com.bookshelf.bookshelf.entities.Book;
import com.bookshelf.bookshelf.mapper.BookMapper;
import com.bookshelf.bookshelf.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    private BookMapper mapper = Mappers.getMapper(BookMapper.class);

    public List<BookDTO> getAll() {
        List<Book> books = repository.findAll();
        return mapper.mapBooks(books);
    }

    public BookDTO save(BookDTO book) {
        Book entity = mapper.mapBookDTO(book);
        repository.save(entity);

        return mapper.mapBook(entity);
    }

    public BookDTO findByID(long id) {
        Optional<Book> book = repository.findById(id);
        return mapper.mapBook(book.get());
    }

    public BookDTO delete(long id) {
        Optional<Book> entity = repository.findById(id);
        
        if (entity.isPresent()) {
            Book book = entity.get();
            repository.delete(book);
            return mapper.mapBook(book);
        }

        return null;
    }
    
}
