package com.bookshelf.bookshelf;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> getAll() {
        return repository.findAll();
    }

    public Book save(Book entity) {
        return repository.save(entity);
    }

    public Book findByID(long id) {
        return repository.findById(id).orElse(null);
    }

    public Book delete(long id) {
        Optional<Book> entity = repository.findById(id);
        
        if (entity.isPresent()) {
            Book book = entity.get();
            repository.delete(book);
            return book;
        }

        return null;
    }
    
}
